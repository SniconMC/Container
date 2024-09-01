package com.github.sniconmc.container.commands;

import com.github.sniconmc.container.ContainerManager;
import com.github.sniconmc.container.creators.ContainerCreator;
import com.github.sniconmc.container.creators.HotbarCreator;
import com.github.sniconmc.utils.text.TextUtils;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.entity.Player;

import java.util.List;

public class ContainerCommand extends Command {

    public ContainerCommand() {
        super("container", "c");

        setDefaultExecutor((commandSender, commandContext) -> {
            commandSender.sendMessage("Nub!");
        });

        var reloadArgument = ArgumentType.Enum("actions", ContainerActions.class);
        var containerArgument = ArgumentType.String("name");

        addSyntax((commandSender, commandContext) -> {

            if (!(commandSender instanceof Player player)){
                return;
            }

            String actionString = commandContext.get(reloadArgument).toString();
            String nameString = commandContext.get(containerArgument).toString();
            switch (actionString.toLowerCase()) {
                case "set", "s" -> {
                    HotbarCreator.setHotbar(player, nameString);
                }
                case "open", "o" -> {
                    ContainerCreator.openContainer(player, nameString);
                }
            }
        }, reloadArgument, containerArgument);

        addSyntax((commandSender, commandContext) -> {

            if (!(commandSender instanceof Player player)){
                return;
            }

            String actionString = commandContext.get(reloadArgument).toString();

            switch (actionString.toLowerCase()) {
                case "reload", "r" -> {
                    ContainerManager.reloadContainers();
                    commandSender.sendMessage(TextUtils.convertStringToComponent(List.of("<green>Reloaded Container!</green>")));
                }
            }
        }, reloadArgument);
    }
}
