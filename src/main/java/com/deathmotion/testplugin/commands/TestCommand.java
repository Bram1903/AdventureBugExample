package com.deathmotion.testplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.deathmotion.testplugin.TestPlugin;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.command.CommandSender;

@CommandAlias("test")
public class TestCommand extends BaseCommand {
    private final BukkitAudiences adventure;

    public TestCommand(TestPlugin plugin) {
        this.adventure = plugin.getAdventure();
    }

    @Default
    public void test(CommandSender sender) {
        sender.sendMessage("Hello, world!");
    }
}