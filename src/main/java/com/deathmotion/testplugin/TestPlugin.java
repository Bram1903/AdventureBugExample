package com.deathmotion.testplugin;

import com.deathmotion.testplugin.Events.ApolloRegisterEvent;
import lombok.Getter;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class TestPlugin extends JavaPlugin {
    private BukkitAudiences adventure;

    @Override
    public void onEnable() {
        adventure = BukkitAudiences.create(this);

        new ApolloRegisterEvent(this);
    }

    @Override
    public void onDisable() {
        adventure.close();
        getLogger().info("Plugin has been uninitialized!");
    }
}
