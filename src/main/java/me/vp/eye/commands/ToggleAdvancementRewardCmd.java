package me.vp.eye.commands;

import me.vp.eye.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/*
*
* @Author Vp (https://github.com/herravp)
* Code is free to use.
*
*/
public class ToggleAdvancementRewardCmd implements CommandExecutor {
    private final Main plugin;
    public ToggleAdvancementRewardCmd(Main plugin) {this.plugin = plugin;}
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
                sender.sendMessage(ChatColor.GREEN + "[Eye] I will grant a reward when a player unlocks an advancement...");
                return true;
            case "false":
                enabled = false;
                sender.sendMessage(ChatColor.RED + "[Eye] I will not grant a reward when a player unlocks an advancement...");
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