package me.vp.eye;

import me.vp.eye.commands.*;
import me.vp.eye.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/*
*
* @Author Vp (https://github.com/herravp)
* Code is free to use.
*
*/
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        print(ChatColor.GREEN, "[Eye] is starting...");
        print(ChatColor.GREEN, "[Eye] loading commands...");
        getCommand("test").setExecutor(new TestCmd(this));
        getCommand("togglelightning").setExecutor(new ToggleLightingCmd(this));
        getCommand("toggleadvancementreward").setExecutor(new ToggleAdvancementRewardCmd(this));
        getCommand("togglejoinmessage").setExecutor(new TogglePlayerJoinCmd(this));
        getCommand("allowplayercountryfetch").setExecutor(new AllowPlayerCountryFetchCmd(this));

        print(ChatColor.GREEN, "[Eye] registering listeners...");
        registerListeners();

        print(ChatColor.GREEN, "[Eye] intialized..!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        print(ChatColor.RED, "[Eye] stopping...");
    }

    public void print(ChatColor color, String msg) {
        Bukkit.getConsoleSender().sendMessage(color + msg);
    }


    public void registerListeners() {
        List<Listener> listeners = new ArrayList<>();
        listeners.add(new PlayerAdvancementDoneListener());
        listeners.add(new PlayerDeathListener());
        listeners.add(new PlayerJoinListener());

        for (Listener listener : listeners) {
            print(ChatColor.GREEN, listener.toString() + " registered.");
            Bukkit.getServer().getPluginManager().registerEvents(listener, this);
        }
    }
}
