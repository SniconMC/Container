package com.github.sniconmc.container.config;


import java.util.List;

public class ContainerConfig {

    private List<ContainerItem> items;
    private ContainerItem default_item;
    private ContainerInventorySettings settings;

    public ContainerItem getDefault_item() {
        return default_item;
    }

    public ContainerInventorySettings getInventorySettings() {
        return settings;
    }

    public void setInventorySettings(ContainerInventorySettings inventorySettings) {
        this.settings = inventorySettings;
    }

    public List<ContainerItem> getItems() {
        return items;
    }

    public void setItems(List<ContainerItem> items) {
        this.items = items;
    }

    public ContainerItem getItem(int index){
        if (index < 0 || index >= items.size()){
            return null;
        }
        return items.get(index);
    }
    public ContainerItem setItem(int index, ContainerItem item){
        if (index < 0 || index >= items.size()){
            return null;
        }
        return items.set(index, item);
    }
}
