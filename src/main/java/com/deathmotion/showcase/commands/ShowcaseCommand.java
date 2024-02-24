package com.deathmotion.showcase.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import com.deathmotion.showcase.Showcase;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.CommandSender;

@CommandAlias("showcase")
public class ShowcaseCommand extends BaseCommand {
    private final BukkitAudiences adventure;

    public ShowcaseCommand(Showcase plugin) {
        this.adventure = plugin.getAdventure();
    }

    @Default
    public void showcase(CommandSender sender) {
        Component showcaseComponent = Component.text()
                .append(Component.text("Test"))
                .decorate(TextDecoration.BOLD)
                .color(NamedTextColor.RED)
                .build();

        adventure.sender(sender).sendActionBar(showcaseComponent);
    }
}