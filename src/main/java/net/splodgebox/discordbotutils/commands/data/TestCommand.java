package net.splodgebox.discordbotutils.commands.data;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.splodgebox.discordbotutils.commands.CustomCommand;
import net.splodgebox.discordbotutils.utils.MessageBuilder;

import java.awt.*;

public class TestCommand extends CustomCommand {
    public TestCommand() {
        super("test", new String[]{"testing", "trail"},
                new Permission[] {Permission.MESSAGE_MANAGE, Permission.MANAGE_CHANNEL});
    }

    @Override
    public void execute(MessageReceivedEvent event, Member member, MessageChannel messageChannel, String[] args) {
        messageChannel.sendMessage(new MessageBuilder("Test", Color.GREEN)
                .setDescription("Hello, " + member.getAsMention(),
                        "Thank you for executing the test command")
                .build()
        ).queue();
    }
}
