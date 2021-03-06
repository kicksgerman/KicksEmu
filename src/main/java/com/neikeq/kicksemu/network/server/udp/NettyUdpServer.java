package com.neikeq.kicksemu.network.server.udp;

import com.neikeq.kicksemu.config.Localization;
import com.neikeq.kicksemu.io.Output;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class NettyUdpServer {

    private final int port;

    private final EventLoopGroup group;

    private final Bootstrap bootstrap;

    private ChannelFuture channelFuture;

    public NettyUdpServer(int port) {
        this.port = port;

        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();

        initBootstrap();
    }

    void initBootstrap() {
        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ClientHandler());
    }

    public void start() throws InterruptedException {
        Output.println(Localization.get("net.bind.udp", String.valueOf(port)));

        channelFuture = bootstrap.bind(port).sync();
    }
    
    public void close() {
        if (getChannelFuture() != null) {
            getChannelFuture().channel().close();
            getChannelFuture().awaitUninterruptibly();
        }

        group.shutdownGracefully();
    }

    public ChannelFuture getChannelFuture() {
        return channelFuture;
    }
}
