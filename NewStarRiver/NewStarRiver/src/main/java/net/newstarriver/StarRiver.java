package net.newstarriver;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.BotInvitedJoinGroupRequestEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.NewFriendRequestEvent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class StarRiver extends JavaPlugin {
    public static final StarRiver INSTANCE = new StarRiver();
    public static final long StarRiver_startTime = System.currentTimeMillis();
    private StarRiver() {
        super(new JvmPluginDescriptionBuilder("net.windstream.starriver", "0.1.0")
                .name("StarRiver")
                .info("NewStarRiver Version[0.1.0]")
                .author("WindStream")
                .build());
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin loaded!");
        GlobalEventChannel.INSTANCE.subscribeAlways(NewFriendRequestEvent.class, FriendAuto->{
            FriendAuto.accept();
        });
        GlobalEventChannel.INSTANCE.subscribeAlways(BotInvitedJoinGroupRequestEvent.class, GroupAuto->{
            GroupAuto.accept();
        });
        GlobalEventChannel.INSTANCE.registerListenerHost(new ModuleManager());
    }
}