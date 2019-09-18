package me.atticuszambrana.matchmaker.command.cmds.chatmode;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.matchmaker.command.Command;

public class DepressedMode extends Command {
	
	public DepressedMode() {
		super("depressedmode", "Put the chat in DEPRESSED mode!");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(Color.BLUE);
		embed.setDescription(":smiley: :gun: The chat is now in DEPRESSED mode! :smiley: :gun:");
		
		event.getChannel().sendMessage(embed);
		return;
	}
}