package me.vp.eye.commands;

import me.vp.eye.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AllowPlayerCountryFetchCmd implements CommandExecutor {
    private final Main plugin;
    public AllowPlayerCountryFetchCmd(Main plugin) {this.plugin = plugin;}
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "[Eye] You do not have permissions to use this command.");
            return false;
        }
        switch (args[0]) {
            case "true":
                enabled = true;
                sender.sendMessage(ChatColor.GREEN + "[Eye] I will fetch the players country on join...");
                return true;
            case "false":
                enabled = false;
                sender.sendMessage(ChatColor.RED + "[Eye] I will not fetch the players country on join...");
                return false;
            default:
                sender.sendMessage(ChatColor.RED + "[Eye] Wrong arguments..!");
                break;
        }
        return true;
    }

    public static boolean isEnabled() {
        return enabled;
    }
}