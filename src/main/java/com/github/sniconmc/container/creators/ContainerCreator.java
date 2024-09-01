package com.github.sniconmc.container.creators;

import com.github.sniconmc.container.ContainerMain;
import com.github.sniconmc.container.ContainerManager;
import com.github.sniconmc.container.config.ContainerConfig;
import com.github.sniconmc.container.data.ContainerHolder;
import com.github.sniconmc.container.utils.CreateInventory;
import com.github.sniconmc.utils.placeholder.PlaceholderReplacer;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class ContainerCreator {

    public static Map<Player, ContainerHolder> lastUsedInventory = new HashMap<>();

    public static void openContainer(Player player, String containerName) {
        Map<String, String> data = ContainerManager.getDataFileJSONData();

        if (data.get(containerName) == null) {
            ContainerMain.logger.error("Container not found {}", containerName);
            return;
        }

        String placeholderReplacedJson = PlaceholderReplacer.replacePlaceholders(player, data.get(containerName));


        try {
            ContainerConfig config = ContainerManager.getGson().fromJson(placeholderReplacedJson, ContainerConfig.class);

            // Create the inventory
            Inventory inventory = CreateInventory.build(config, player);

            // Open inventory
            player.openInventory(inventory);
            lastUsedInventory.put(player, new ContainerHolder(containerName, inventory));
        } catch (JsonSyntaxException | JsonIOException e) {
            // Handle Gson-specific errors
            ContainerMain.logger.error("Error parsing JSON in: {}", containerName);
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            ContainerMain.logger.error("Unexpected error in: {}", containerName);
        }

    }
}
