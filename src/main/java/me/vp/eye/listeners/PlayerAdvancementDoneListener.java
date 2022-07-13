package me.vp.eye.listeners;

import me.vp.eye.commands.ToggleAdvancementRewardCmd;
import org.bukkit.ChatColor;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

/*
*
* @Author Vp (https://github.com/herravp)
* Code is free to use.
*
*/
public class PlayerAdvancementDoneListener implements Listener {

    @EventHandler
    public void onAdvancementDone(PlayerAdvancementDoneEvent event) {
        if (!ToggleAdvancementRewardCmd.isEnabled()) return;
        Player player = event.getPlayer();
        Advancement advancement = event.getAdvancement();

        if (player.getAdvancementProgress(advancement).isDone() && ToggleAdvancementRewardCmd.isEnabled()) {
            if (advancement.getKey().getKey().startsWith("recipes/") || advancement.getKey().getKey().startsWith("root/")) return;

            player.sendMessage(ChatColor.GREEN + "[Eye] You have completed an advancement, " + ChatColor.YELLOW + ChatColor.ITALIC + advancement.getDisplay().getTitle() +
                               ChatColor.RESET + ChatColor.GREEN + ", and got, " + ChatColor.YELLOW + ChatColor.ITALIC + giveRandomExp()
                               + ChatColor.RESET + ChatColor.GREEN + " experience..!");
            player.giveExp(giveRandomExp());
        }
    }

    // really ez and lazy way to make this frr.
    public int giveRandomExp() {
        int minExp = 15;
        int maxExp = 250;
        return (int) Math.floor(Math.random() * (maxExp - minExp + 1) + minExp);
    }
}