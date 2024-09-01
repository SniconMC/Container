package com.github.sniconmc.container.data;

import net.minestom.server.inventory.Inventory;

public class ContainerHolder {

    private final String containerName;

    private final Inventory inventory;

    public ContainerHolder(String containerName, Inventory inventory) {
        this.containerName = containerName;
        this.inventory = inventory;
    }

    public String getContainerName() {
        return containerName;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
