package me.atticuszambrana.matchmaker.command.cmds.info;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.matchmaker.command.Command;
import me.atticuszambrana.matchmaker.command.CommandCenter;

public class HelpCommand extends Command {
	public HelpCommand() {
		super("help", "Display help info for the bot");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		
		for(Command cmd : CommandCenter.commands) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setColor(Color.ORANGE);
			embed.addField(cmd.getCommandName(), cmd.getCommandDescription(), true);
			event.getChannel().sendMessage(embed);
		}
		
	}
}
