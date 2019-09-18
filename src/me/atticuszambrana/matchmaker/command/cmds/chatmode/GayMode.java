package me.atticuszambrana.matchmaker.command.cmds.chatmode;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.matchmaker.command.Command;

public class GayMode extends Command {
	
	public GayMode() {
		super("gaymode", "Put the chat in GAY mode!");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(Color.PINK);
		embed.setDescription(":gay_pride_flag: The chat is now in GAY mode! :gay_pride_flag: ");
		
		event.getChannel().sendMessage(embed);
		return;
	}

}
