package com.neikeq.kicksemu.game.characters;

import com.neikeq.kicksemu.game.inventory.Celebration;
import com.neikeq.kicksemu.game.inventory.Item;
import com.neikeq.kicksemu.game.inventory.Skill;
import com.neikeq.kicksemu.game.inventory.Training;
import com.neikeq.kicksemu.game.sessions.Session;
import com.neikeq.kicksemu.network.packets.out.MessageBuilder;
import com.neikeq.kicksemu.network.packets.out.ServerMessage;

import java.util.Map;

public class CharacterManager {

    public static void playerInfo(Session session) {
        sendItemList(session);
        sendTrainingList(session);
        sendSkillList(session);
        sendCelebrationList(session);
        sendPlayerInfo(session);
    }

    private static void sendPlayerInfo(Session session) {
        ServerMessage msg = MessageBuilder.playerInfo(session.getPlayerId(), (byte)0);
        session.send(msg);
    }

    private static void sendItemList(Session session) {
        Map<Integer, Item> items = PlayerInfo.getInventoryItems(session.getPlayerId());

        ServerMessage msg = MessageBuilder.itemList(items, (byte)0);
        session.send(msg);
    }

    private static void sendTrainingList(Session session) {
        Map<Integer, Training> trainings = PlayerInfo.getInventoryTraining(session.getPlayerId());

        ServerMessage msg = MessageBuilder.trainingList(trainings, (byte) 0);
        session.send(msg);
    }

    private static void sendSkillList(Session session) {
        Map<Integer, Skill> items = PlayerInfo.getInventorySkills(session.getPlayerId());

        ServerMessage msg = MessageBuilder.skillList(items, (byte) 0);
        session.send(msg);
    }

    private static void sendCelebrationList(Session session) {
        Map<Integer, Celebration> items =
                PlayerInfo.getInventoryCelebration(session.getPlayerId());

        ServerMessage msg = MessageBuilder.celebrationList(items, (byte) 0);
        session.send(msg);
    }

    public static void gameExit(Session session) {
        int playerId = session.getPlayerId();

        ServerMessage response = MessageBuilder.gameExit(session.getRemoteAddress(), playerId);
        session.send(response);

        session.close();
    }
}
