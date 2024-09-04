package com.github.sniconmc.container.utils;

import com.github.sniconmc.container.creators.ContainerCreator;
import com.github.sniconmc.container.creators.HotbarCreator;
import com.github.sniconmc.container.data.ContainerHolder;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;

public class ReloadContainer {

    public static void reloadCurrentContainers(Player player){



        String currentHotbar = HotbarCreator.currentHotbar.get(player);
        if (currentHotbar != null) {
            HotbarCreator.setHotbar(player, currentHotbar);
        }

        ContainerHolder holder = ContainerCreator.lastUsedInventory.get(player);
        if (holder != null && player.getOpenInventory() == holder.getInventory()) {
            ContainerCreator.openContainer(player, holder.getContainerName());
        }


    }
}
