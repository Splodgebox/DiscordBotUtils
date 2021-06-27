package net.splodgebox.discordbotutils.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MessageBuilder {

    private EmbedBuilder embedBuilder;

    public MessageBuilder(String title, Color color) {
        embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(title);
        embedBuilder.setColor(color);
    }

    public MessageBuilder(Color color) {
        embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(color);
    }

    public MessageBuilder setDescription(String... description) {
        Arrays.stream(description).forEach(s -> embedBuilder.appendDescription(s + "\n"));
        return this;
    }

    public MessageBuilder setDescription(List<String> description) {
        description.forEach(s -> embedBuilder.appendDescription(s + "\n"));
        return this;
    }

    public MessageBuilder setImage(String url) {
        embedBuilder.setImage(url);
        return this;
    }

    public MessageEmbed build() {
        return embedBuilder
                .setFooter("Created by Splodgebox#3490", "https://i.imgur.com/eCAPkZ5.png")
                .build();
    }

}
