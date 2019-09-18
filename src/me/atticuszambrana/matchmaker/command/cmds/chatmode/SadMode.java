package me.atticuszambrana.matchmaker.command.cmds.chatmode;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.matchmaker.command.Command;

public class SadMode extends Command {
	
	public SadMode() {
		super("sadmode", "Put the chat in SAD mode!");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(Color.BLUE);
		embed.setDescription(":cry: The chat is now in SAD mode! :cry: ");
		
		event.getChannel().sendMessage(embed);
		return;
	}

}
