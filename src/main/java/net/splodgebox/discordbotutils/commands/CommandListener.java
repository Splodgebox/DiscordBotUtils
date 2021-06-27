package net.splodgebox.discordbotutils.commands;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.splodgebox.discordbotutils.utils.MessageBuilder;

import java.awt.*;

@RequiredArgsConstructor
public class CommandListener extends ListenerAdapter {

    private final CommandHandler commandHandler;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || event.getMember() == null || event.getAuthor().isSystem()) return;
        String[] args = event.getMessage().getContentRaw().split(" ");

        CustomCommand customCommand = commandHandler.match(args[0]);
        if (customCommand == null) return;

        if (!event.getMember().hasPermission(customCommand.getPermissions())) {
            event.getChannel().sendMessage(new MessageBuilder("**ERROR** | No Permission", Color.RED)
                    .setDescription("You do not have permission to execute that command!")
                    .build()).queue();
            return;
        }

        customCommand.execute(event, event.getMember(), event.getChannel(), args);
    }

}
