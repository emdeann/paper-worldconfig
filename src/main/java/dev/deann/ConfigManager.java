package dev.deann;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager implements Listener {

    final Material SPAWN_BLOCK = Material.GOLD_BLOCK;
    final Material CHEST_BLOCK = Material.CHEST;
    private static ArrayList<String> chestLocations = new ArrayList<>();
    private static ArrayList<String> spawnLocations = new ArrayList<>();



    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Coordinate loc = new Coordinate(event.getBlockPlaced().getX(), event.getBlockPlaced().getY(),
                event.getBlockPlaced().getZ());
        Material eventMaterial = event.getBlockPlaced().getBlockData().getMaterial();
        if (eventMaterial == SPAWN_BLOCK) {
            spawnLocations.add(loc.toString());
            event.getPlayer().sendMessage(Component.text("Spawn added at " + loc, NamedTextColor.DARK_PURPLE));
        }
        else if (eventMaterial == CHEST_BLOCK) {
            chestLocations.add(loc.toString());
            event.getPlayer().sendMessage(Component.text("Chest added at " + loc, NamedTextColor.DARK_PURPLE));
        }
    }


   public static boolean dumpConfig() {
        Map<String, ArrayList<String>> yamlMap = new HashMap<>();
        yamlMap.put("Spawns", spawnLocations);
        yamlMap.put("Chests", chestLocations);
        Yaml yaml = new Yaml();
        FileWriter writer;
        try {
            writer = new FileWriter("C:/Users/dtm44/Desktop/config.yml");
        } catch (IOException e) {

            System.out.println(e.getMessage());
            return false;
        }

        yaml.dump(yamlMap, writer);
        chestLocations.clear();
        spawnLocations.clear();
        return true;
    }
}
