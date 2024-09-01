package com.github.sniconmc.container;

import com.github.sniconmc.container.creators.ContainerCreator;
import com.github.sniconmc.container.creators.HotbarCreator;
import com.github.sniconmc.container.data.ContainerHolder;
import com.github.sniconmc.container.utils.LoadContainer;
import com.github.sniconmc.container.utils.ReloadContainer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.Inventory;

import java.io.File;
import java.util.Map;

public class ContainerManager {

    // Load new Gson
    private static Gson gson = new Gson();

    private static final File dataFolder = new File("resources/container");

    private static Map<String, String> dataFileJSONData;

    public ContainerManager() {

        gson = new GsonBuilder().setPrettyPrinting().create();

        dataFileJSONData = new LoadContainer().load(dataFolder);

    }

    public static void reloadContainers() {
        dataFileJSONData = new LoadContainer().load(dataFolder);

        ReloadContainer.reloadCurrentContainers();
    }

    public static Map<String, String> getDataFileJSONData(){
        return dataFileJSONData;
    }

    public static Gson getGson(){
        return gson;
    }
}
