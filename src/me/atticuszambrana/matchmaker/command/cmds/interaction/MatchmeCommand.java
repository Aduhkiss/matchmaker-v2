package me.atticuszambrana.matchmaker.command.cmds.interaction;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.matchmaker.command.Command;
import me.atticuszambrana.matchmaker.util.RoleUtil;
import me.atticuszambrana.matchmaker.util.ServerUtil;

public class MatchmeCommand extends Command {
	
	public MatchmeCommand() {
		super("matchme", "Get matched with someone with similar tags!");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		try {
			
			EmbedBuilder embed = new EmbedBuilder();
			
			embed.setColor(Color.PINK);
			embed.setTitle("You have been matched with...");
			
			User match = null;
			try {
				match = match(event.getMessageAuthor().asUser().get(), event);
			} catch(Exception ex) {
//				embed.setColor(Color.RED);
//				embed.setTitle("I found no one!");
//				embed.setDescription("Sorry, but there was no one on this server, that matches your roles!");
				System.out.println("Error! No match found!");
				return;
			}
			
			embed.setDescription("You have been matched with " + match.getName() + "!");
			
			event.getChannel().sendMessage(embed);
			return;
		} catch(StackOverflowError ex) {
			EmbedBuilder embed = new EmbedBuilder();
			
			embed.setColor(Color.RED);
			embed.setDescription("Sorry, but I was unable to find you a match!");
			
			event.getChannel().sendMessage(embed);
		}
	}
	
	// All of the matchmaking algorithim code will be shoved in here to make it easier
	
	public User match(User user, MessageCreateEvent event) {
		User match = (User) ServerUtil.getRandomObject(event.getServer().get().getMembers());
		Server s = event.getServer().get();
		
		if(match.isBot()) {
			return match(user, event);
		}
		
		if(RoleUtil.hasRole(match, s, "Not Looking") || RoleUtil.hasRole(match, s, "Taken")) {
			return match(user, event);
		}
		
		if(RoleUtil.hasRole(user, event.getServer().get(), "Straight")) {
			if(RoleUtil.hasRole(match, event.getServer().get(), "Boy") && RoleUtil.hasRole(user, event.getServer().get(), "Boy")) {
				return match(user, event);
			}
			if(RoleUtil.hasRole(match, event.getServer().get(), "Girl") && RoleUtil.hasRole(user, event.getServer().get(), "Girl")) {
				return match(user, event);
			}
		} else if(RoleUtil.hasRole(user, event.getServer().get(), "Gay")) {
			if(RoleUtil.hasRole(match, event.getServer().get(), "Boy") && RoleUtil.hasRole(user, event.getServer().get(), "Girl")) {
				return match(user, event);
			}
			if(RoleUtil.hasRole(match, event.getServer().get(), "Girl") && RoleUtil.hasRole(user, event.getServer().get(), "Boy")) {
				return match(user, event);
			}
		}
		
		return match;
	}

}
