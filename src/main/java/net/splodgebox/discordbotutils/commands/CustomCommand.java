package net.splodgebox.discordbotutils.commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Getter
@RequiredArgsConstructor
public abstract class CustomCommand {

    private final String command;
    private final String[] aliases;
    private final Permission[] permissions;

    public abstract void execute(MessageReceivedEvent event, Member member, MessageChannel messageChannel, String[] args);

}