package net.splodgebox.discordbotutils;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.splodgebox.discordbotutils.commands.CommandHandler;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    @Getter
    private static JDA jda;

    // Replace this with your Bot Token
    private static final String BOT_TOKEN = "YOUR-ID";

    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault(BOT_TOKEN);

        try {
            jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

        // Register all the commands
        new CommandHandler();
    }

}
