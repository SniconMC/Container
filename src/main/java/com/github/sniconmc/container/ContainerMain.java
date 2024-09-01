package com.github.sniconmc.container;

import com.github.sniconmc.container.commands.ContainerCommand;
import net.minestom.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContainerMain {

    public static final Logger logger = LoggerFactory.getLogger(ContainerMain.class);

    public static void main(String[] args) {
        logger.info("Container initialized");

        ContainerManager containerManager = new ContainerManager();

        MinecraftServer.getCommandManager().register(new ContainerCommand());

    }
}