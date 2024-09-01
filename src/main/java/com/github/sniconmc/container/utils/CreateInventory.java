package com.github.sniconmc.container.utils;

import com.github.sniconmc.container.config.*;
import com.github.sniconmc.utils.inventory.InventoryUtils;
import com.github.sniconmc.utils.item.ItemStackBuilder;
import com.github.sniconmc.utils.item.MaterialUtils;
import com.github.sniconmc.utils.text.TextUtils;
import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.inventory.PlayerInventory;
import net.minestom.server.item.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateInventory {


    private static Player playerInUse = null;

    public static Inventory build(ContainerConfig config, Player player){

        playerInUse = player;

        ContainerInventorySettings inventorySettings = config.getInventorySettings();

        Component displayName = TextUtils.convertStringToComponent(inventorySettings.getDisplayName());
        InventoryType inventoryType = InventoryUtils.getInventoryType(inventorySettings.getRow());
        Integer inventorySize = inventorySettings.getSize();

        Inventory inventory = new Inventory(inventoryType, displayName);

        Map<Integer, ContainerItem> nonDefaultItems = getNonDefaultItems(config.getItems());

        addItemsToInventoryWithDefault(inventory, inventorySize, nonDefaultItems, config.getDefault_item());


        return inventory;
    }


    public static void addItemsToInventoryWithDefault(Inventory inventory, Integer inventorySize, Map<Integer, ContainerItem> items, ContainerItem defaultItem) {

        for (int slot = 0; slot < inventorySize; slot++) {
            ContainerItem nonDefaultItem = items.get(slot);

            ContainerItem item = defaultItem;
            ContainerItemCount itemCount = defaultItem.getCount();
            ContainerItemDisplay itemDisplay = defaultItem.getDisplay();
            ContainerItemSkin itemSkin = defaultItem.getSkin();
            ContainerItemData itemData = defaultItem.getData();

            if (nonDefaultItem != null) {
                item = nonDefaultItem;
                itemCount = item.getCount();
                itemDisplay = item.getDisplay();
                itemSkin = item.getSkin();
                 itemData = item.getData();
            }


            ItemStack containerItem = new ItemStackBuilder().material(MaterialUtils.convertToNamespaceIdMaterial(item.getId()))
                    .count(itemCount.getCurrent())
                    .maxStackSize(itemCount.getMax())
                    .name(TextUtils.convertStringToComponent(itemDisplay.getName()))
                    .lore(TextUtils.convertListStringToListComponent(itemDisplay.getLore()))
                    .glint(itemDisplay.isGlint())
                    .showToolTips(itemDisplay.isShow_tooltip())
                    .dyeColor(itemDisplay.getDye_color())
                    .isVanillaItem(itemData.isVanillaItem())
                    .function(itemData.getFunction())
                    .page(itemData.getPage())
                    .playerSkull(itemSkin.getPlayer(), playerInUse)
                    .uuid(itemSkin.getUuid())
                    .texture(itemSkin.getTexture())
                    .build();

            inventory.setItemStack(slot, containerItem);
        }

    }

    public static void addItemsToPlayerInventory(PlayerInventory inventory, Integer inventorySize, Map<Integer, ContainerItem> items) {

        for (int slot = 0; slot < inventorySize; slot++) {
            ContainerItem item = items.get(slot);


            if (item == null) {
                return;
            }

            ContainerItemCount itemCount = item.getCount();
            ContainerItemDisplay itemDisplay = item.getDisplay();
            ContainerItemSkin itemSkin = item.getSkin();
            ContainerItemData itemData = item.getData();

            ItemStack containerItem = new ItemStackBuilder().material(MaterialUtils.convertToNamespaceIdMaterial(item.getId()))
                    .count(itemCount.getCurrent())
                    .maxStackSize(itemCount.getMax())
                    .name(TextUtils.convertStringToComponent(itemDisplay.getName()))
                    .lore(TextUtils.convertListStringToListComponent(itemDisplay.getLore()))
                    .glint(itemDisplay.isGlint())
                    .showToolTips(itemDisplay.isShow_tooltip())
                    .dyeColor(itemDisplay.getDye_color())
                    .isVanillaItem(itemData.isVanillaItem())
                    .function(itemData.getFunction())
                    .page(itemData.getPage())
                    .playerSkull(itemSkin.getPlayer(), playerInUse)
                    .uuid(itemSkin.getUuid())
                    .texture(itemSkin.getTexture())
                    .build();

            inventory.setItemStack(slot, containerItem);
        }

    }

    public static Map<Integer, ContainerItem> getNonDefaultItems(List<ContainerItem> items) {
        Map<Integer, ContainerItem> itemMap = new HashMap<>();
        for (ContainerItem item : items) {
            itemMap.put(item.getSlot(), item);
        }
        return itemMap;
    }

}
