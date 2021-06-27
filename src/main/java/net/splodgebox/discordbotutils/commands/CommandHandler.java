package net.splodgebox.discordbotutils.commands;

import lombok.Getter;
import net.splodgebox.discordbotutils.DiscordBot;
import net.splodgebox.discordbotutils.commands.data.TestCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandHandler {

    @Getter
    private final List<CustomCommand> commands;
    public static final Character COMMAND_PREFIX = '!';

    public CommandHandler() {
        commands = new ArrayList<>();
        DiscordBot.getJda().addEventListener(new CommandListener(this));

        registerCommand(
                new TestCommand()
        );
    }

    public void registerCommand(CustomCommand... customCommands) {
        Collections.addAll(commands, customCommands);
    }

    public CustomCommand match(String command) {
        for (CustomCommand customCommand : commands) {
            if (command.equalsIgnoreCase(COMMAND_PREFIX + customCommand.getCommand())) {
                return customCommand;
            }

            if (customCommand.getAliases().length > 0) {
                for (String alias : customCommand.getAliases()) {
                    if (command.equalsIgnoreCase(COMMAND_PREFIX + alias)) {
                        return customCommand;
                    }
                }
            }
        }

        return null;
    }

}
