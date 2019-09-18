package me.atticuszambrana.matchmaker.command.cmds.chatmode;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.matchmaker.command.Command;

public class HappyMode extends Command {
	
	public HappyMode() {
		super("happymode", "Put the chat in HAPPY mode!");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(Color.GREEN);
		embed.setDescription(":smiley: The chat is now in HAPPY mode! :smiley:");
		
		event.getChannel().sendMessage(embed);
		return;
	}

}
