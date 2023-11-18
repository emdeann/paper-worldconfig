package dev.deann;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BuildCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (ConfigManager.dumpConfig()) {
            CommandHelpers.sendMessage(Component.text("Config saved to YAML!", NamedTextColor.DARK_PURPLE), sender);
            return true;
        } else {
            CommandHelpers.sendMessage(Component.text("Internal file operation failed", NamedTextColor.RED), sender);
            return false;
        }
    }
}
