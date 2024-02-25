package com.deathmotion.test.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.deathmotion.test.Test;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.command.CommandSender;

@CommandAlias("test")
public class TestCommand extends BaseCommand {
    private final BukkitAudiences adventure;

    public TestCommand(Test plugin) {
        this.adventure = plugin.getAdventure();
    }

    @Default
    public void showcase(CommandSender sender) {
        sender.sendMessage("Hello, world!");
    }
}