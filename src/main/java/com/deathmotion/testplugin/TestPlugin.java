package com.deathmotion.testplugin;

import co.aikar.commands.PaperCommandManager;
import com.deathmotion.testplugin.commands.TestCommand;
import lombok.Getter;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class TestPlugin extends JavaPlugin {
    private BukkitAudiences adventure;
    private PaperCommandManager commandManager;

    @Override
    public void onEnable() {
        adventure = BukkitAudiences.create(this);

        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new TestCommand(this));
    }

    @Override
    public void onDisable() {
        adventure.close();
        getLogger().info("Plugin has been uninitialized!");
    }
}
