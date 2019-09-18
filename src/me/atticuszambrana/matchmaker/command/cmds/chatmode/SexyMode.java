package me.atticuszambrana.matchmaker.command.cmds.chatmode;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.matchmaker.command.Command;

public class SexyMode extends Command {
	
	public SexyMode() {
		super("sexymode", "Put the chat in SEXY mode!");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(Color.RED);
		embed.setDescription(":heartbeat: The chat is now in SEXY mode! :heartbeat: ");
		
		event.getChannel().sendMessage(embed);
		return;
	}
}