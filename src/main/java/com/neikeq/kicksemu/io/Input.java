package com.neikeq.kicksemu.io;

import com.neikeq.kicksemu.game.chat.ChatUtils;
import com.neikeq.kicksemu.io.logging.Level;
import com.neikeq.kicksemu.KicksEmu;
import com.neikeq.kicksemu.config.Configuration;
import com.neikeq.kicksemu.config.Localization;
import com.neikeq.kicksemu.io.logging.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/** Input listener. */
public class Input {

    /** List of valid commands. */
    private Map<String, InputHandler> commands;
    
    public void listen() {
        try (Scanner scanner = new Scanner(System.in)) {
        	while (Thread.currentThread().isAlive()) {
	            if (scanner.hasNextLine()) {
	                String input = scanner.nextLine();
	                
	                if (!input.isEmpty()) {
	                    handle(input);
	                }
	            }
	        }
        }
    }
    
    private void handle(String input) {
        String[] args = input.split(" ");

        if (args.length < 2) {
            args = new String[] { args[0], "" };
        }

        if (commands.containsKey(args[0])) {
            commands.get(args[0]).handle(args);
        } else {
            System.out.println(Localization.get("input.error", input));
        }
    }

    private void handleSave(String ... arg) {
        try {
            switch (arg[1]) {
                case "config":
                    Configuration.getInstance().save();
                    break;
                case "lang":
                    Localization.getInstance().save();
                    break;
                default:
                    System.out.println(Localization.get("input.error", arg[1]));
            }
        } catch (IOException e) {
            Output.println("Cannot save " + arg[1] + " file: " + e.getMessage(), Level.WARNING);
        }
    }

    private void handleLogs(String ... arg) {
        switch (arg[1]) {
            case "true":
                Logger.getInstance().setLogging(true);
                break;
            case "false":
                Logger.getInstance().setLogging(false);
                break;
            default:
                System.out.println(Logger.getInstance().getLogging());
        }
    }

    private void handleVerbosity(String ... arg) {
        switch (arg[1]) {
            case "debug":
                KicksEmu.getInstance().getOutput().setLevel(Level.DEBUG);
                break;
            case "info":
                KicksEmu.getInstance().getOutput().setLevel(Level.INFO);
                break;
            case "warning":
                KicksEmu.getInstance().getOutput().setLevel(Level.WARNING);
                break;
            case "critical":
                KicksEmu.getInstance().getOutput().setLevel(Level.CRITICAL);
                break;
            default:
                System.out.println(Localization.get("input.error", arg[1]));
        }
    }

    private void handleNotice(String ... arg) {
        StringBuilder message = new StringBuilder();

        for (int i = 1; i < arg.length; i++) {
            message.append(arg[i]);
            message.append(" ");
        }

        ChatUtils.broadcastNotice(message.toString());
    }

    void defineCommands() {
        commands = new TreeMap<>();
        commands.put("save", this::handleSave);
        commands.put("logs", this::handleLogs);
        commands.put("verb", this::handleVerbosity);
        commands.put("stop", (arg) -> KicksEmu.getInstance().stop());
        commands.put("notice", this::handleNotice);
    }

    public Input() {
        defineCommands();
    }

    @FunctionalInterface
    private interface InputHandler {
        void handle(String ... arg);
    }
}
