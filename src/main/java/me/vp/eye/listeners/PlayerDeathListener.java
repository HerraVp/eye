package me.vp.eye.listeners;

import me.vp.eye.commands.ToggleLightingCmd;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/*
*
* @Author Vp (https://github.com/herravp)
* Code is free to use.
*
*/
public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (!ToggleLightingCmd.isEnabled()) return;

        Player player = event.getEntity().getPlayer();
        Location pos = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());

        if (player.getHealth() <= 0 && ToggleLightingCmd.isEnabled()) {
            player.getWorld().strikeLightning(pos);
        }
    }
}