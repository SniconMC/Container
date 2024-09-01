package com.github.sniconmc.container.creators;

import com.github.sniconmc.container.ContainerMain;
import com.github.sniconmc.container.ContainerManager;
import com.github.sniconmc.container.config.ContainerConfig;
import com.github.sniconmc.container.config.ContainerItem;
import com.github.sniconmc.container.utils.CreateInventory;
import com.github.sniconmc.utils.placeholder.PlaceholderReplacer;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.PlayerInventory;

import java.util.Map;

public class HotbarCreator {

    public static Map<Player, String> currentHotbar;

    public static void setHotbar(Player player, String hotbarName) {
        Map<String, String> data = ContainerManager.getDataFileJSONData();

        if (data.get(hotbarName) == null) {
            ContainerMain.logger.error("Container not found {}", hotbarName);
            return;
        }

        String placeholderReplacedJson = PlaceholderReplacer.replacePlaceholders(player, data.get(hotbarName));


        try {
            ContainerConfig config = ContainerManager.getGson().fromJson(placeholderReplacedJson, ContainerConfig.class);

            // Get player inventory
            PlayerInventory inventory = player.getInventory();

            CreateInventory.addItemsToPlayerInventory(inventory, inventory.getInnerSize(), CreateInventory.getNonDefaultItems(config.getItems()));

            currentHotbar.put(player, hotbarName);
        } catch (JsonSyntaxException | JsonIOException e) {
            // Handle Gson-specific errors
            ContainerMain.logger.error("Error parsing JSON in: {}", hotbarName);
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            ContainerMain.logger.error("Unexpected error in: {}, {}", hotbarName,  e.toString());
        }

    }
}
