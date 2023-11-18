package dev.deann;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldConfig extends JavaPlugin {
    private static WorldConfig instance;
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ConfigManager(), this);
        Bukkit.getPluginCommand("buildYaml").setExecutor(new BuildCommandExecutor());
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JavaPlugin getInstance() {
        return instance;
    }


}
