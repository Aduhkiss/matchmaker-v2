package me.atticuszambrana.matchmaker.command;

import java.util.ArrayList;
import java.util.List;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import me.atticuszambrana.matchmaker.Matchmaker;
import me.atticuszambrana.matchmaker.command.cmds.chatmode.CrazyMode;
import me.atticuszambrana.matchmaker.command.cmds.chatmode.DepressedMode;
import me.atticuszambrana.matchmaker.command.cmds.chatmode.GayMode;
import me.atticuszambrana.matchmaker.command.cmds.chatmode.HappyMode;
import me.atticuszambrana.matchmaker.command.cmds.chatmode.SadMode;
import me.atticuszambrana.matchmaker.command.cmds.chatmode.SexyMode;
import me.atticuszambrana.matchmaker.command.cmds.info.HelpCommand;
import me.atticuszambrana.matchmaker.command.cmds.interaction.HugCommand;
import me.atticuszambrana.matchmaker.command.cmds.interaction.KissCommand;
import me.atticuszambrana.matchmaker.command.cmds.interaction.MatchmeCommand;
import me.atticuszambrana.matchmaker.util.TimeUtil;

public class CommandCenter implements MessageCreateListener {
	
	public static List<Command> commands;
	Matchmaker grass;
	
	public CommandCenter(Matchmaker grass) {
		this.grass = grass;
		commands = new ArrayList<Command>();
		
		registerCommands();
	}
	
	private void registerCommands() {
		// Information
		commands.add(new HelpCommand());
		
		// Interaction
		commands.add(new MatchmeCommand());
		commands.add(new HugCommand());
		commands.add(new KissCommand());
		
		// Chat modes
		commands.add(new GayMode());
		commands.add(new SadMode());
		commands.add(new HappyMode());
		commands.add(new CrazyMode());
		commands.add(new DepressedMode());
		commands.add(new SexyMode());
	}
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		// Grab the prefix real quick from the config
		String prefix = grass.getConfig().getPrefix();
		boolean delete = grass.getConfig().getDeleteOnRun();
		
		// Make sure that we are only looking for messages that were sent by people
		if(event.getMessageAuthor().isBotUser()) {
			return;
		}
		
		// Then go through all of the commands
		for(Command cmd : commands) {
			// And if the message starts with the prefix and the command
			if(event.getMessageContent().startsWith(prefix + cmd.getCommandName())) {
				// Then execute the command
				if(delete) {
					// Figure out how the frick to actually delete the message
					//event.getMessage().delete().complete();
				}
				cmd.execute(event);
				
				// Log the running of the command
				System.out.println("-----------------------------");
				System.out.println("Name: " + event.getMessageAuthor().getName());
				System.out.println("Discord ID: " + event.getMessageAuthor().getId());
				System.out.println("Command: " + cmd.getCommandName());
				System.out.println("Full Content: " + event.getMessageContent());
				System.out.println("Current Timestamp: " + TimeUtil.getCurrentTimeDate());
				System.out.println("-----------------------------");
				return;
			}
		}
	}

}
