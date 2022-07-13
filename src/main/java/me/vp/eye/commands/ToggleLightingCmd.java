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
public class ToggleLightingCmd implements CommandExecutor {
    private final Main plugin;
    public ToggleLightingCmd(Main plugin) {this.plugin = plugin;}

    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "[Eye] You do not have permissions to use this command.");
            return !enabled;
        }

        switch (args[0].toLowerCase()) {
            case "true":
                enabled = true;
                sender.sendMessage(ChatColor.GREEN + "[Eye] I will summon a lightingbolt when a player dies...");
                return true;
            case "false":
                enabled = false;
                sender.sendMessage(ChatColor.RED + "[Eye] I will stay calm when a player dies...");
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