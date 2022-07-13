package me.vp.eye.listeners;

import me.vp.eye.commands.AllowPlayerCountryFetchCmd;
import me.vp.eye.commands.TogglePlayerJoinCmd;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URL;

/*
 *
 * @Author Vp (https://github.com/herravp)
 * Code is free to use.
 *
*/
public class PlayerJoinListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) throws Exception {
        if (!TogglePlayerJoinCmd.isEnabled()) return;
        Player player = event.getPlayer();
        InetSocketAddress ip = player.getAddress();
        String country = getCountry(ip).substring(0, 1).toUpperCase() + getCountry(ip).substring(1).toLowerCase();

        if (TogglePlayerJoinCmd.isEnabled()) {
            if (ip.isUnresolved() || !AllowPlayerCountryFetchCmd.isEnabled())
                event.setJoinMessage(ChatColor.GREEN + player.getName() + " has joined.");
            else
                try {
                    event.setJoinMessage(ChatColor.GREEN + player.getName() + " has joined from " + country + ".");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    // fetch the players country
    public static String getCountry(InetSocketAddress ip) throws Exception {
        URL url = new URL("http://ip-api.com/json/" + ip.getHostName());
        BufferedReader stream = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder entirePage = new StringBuilder();
        String inputLine;
        while ((inputLine = stream.readLine()) != null)
            entirePage.append(inputLine);
        stream.close();
        if (!(entirePage.toString().contains("\"country\":\"")))
            return null;
        return entirePage.toString().split("\"country\":\"")[1].split("\",")[0];
    }

}