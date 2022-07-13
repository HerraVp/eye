package me.vp.eye.commands;

import me.vp.eye.Main;
import org.bukkit.Bukkit;
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
public class TestCmd implements CommandExecutor {
    private final Main plugin;
    public TestCmd(Main plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "[Eye] You do not have permissions to use this command.");
            return false;
        } else sender.sendMessage(ChatColor.GREEN + "[Eye] You have permissions to use this command.");

        return true;
    }
}
