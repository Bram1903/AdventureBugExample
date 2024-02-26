package com.deathmotion.testplugin.Events;

import com.deathmotion.testplugin.TestPlugin;
import com.lunarclient.apollo.Apollo;
import com.lunarclient.apollo.event.ApolloListener;
import com.lunarclient.apollo.event.EventBus;
import com.lunarclient.apollo.event.Listen;
import com.lunarclient.apollo.event.player.ApolloRegisterPlayerEvent;
import com.lunarclient.apollo.module.staffmod.StaffModModule;
import com.lunarclient.apollo.player.ApolloPlayer;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;

public class ApolloRegisterEvent implements ApolloListener {

    private final BukkitAudiences adventure;

    private final StaffModModule staffModModule;
    private final Component staffModEnabledComponent;

    public ApolloRegisterEvent(TestPlugin plugin) {
        EventBus.getBus().register(this);

        adventure = plugin.getAdventure();

        staffModModule = Apollo.getModuleManager().getModule(StaffModModule.class);
        staffModEnabledComponent = Component.text()
                .append(Component.text("StaffMod has been enabled!"))
                .color(NamedTextColor.GREEN)
                .build();
    }

    @Listen
    public void onApolloRegister(ApolloRegisterPlayerEvent event) {
        ApolloPlayer apolloPlayer = event.getPlayer();
        staffModModule.enableAllStaffMods(apolloPlayer);

        CommandSender sender = (CommandSender) apolloPlayer.getPlayer();
        adventure.sender(sender).sendMessage(staffModEnabledComponent);
    }
}
