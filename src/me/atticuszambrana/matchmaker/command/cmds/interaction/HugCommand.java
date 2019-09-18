package me.atticuszambrana.matchmaker.command.cmds.interaction;

import java.awt.Color;
import java.lang.reflect.Member;
import java.util.List;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.matchmaker.common.InteractionCommand;
import me.atticuszambrana.matchmaker.util.EmbedUtil;
import me.atticuszambrana.matchmaker.util.EmbedUtil.EmbedType;

public class HugCommand extends InteractionCommand {

	public HugCommand() {
		super("hug", "Give someone a hug!");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		
		List<User> targets = event.getMessage().getMentionedUsers();
		
		if(targets.isEmpty()) {
			event.getChannel().sendMessage(EmbedUtil.get(EmbedType.ERROR, "You are required to mention a user!"));
			return;
		}
		if(targets.size() > 1) {
			event.getChannel().sendMessage(EmbedUtil.get(EmbedType.ERROR, "You can only mention 1 user at a time!"));
			return;
		}
		
		User member = targets.get(0);
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(Color.PINK);
		embed.setDescription(event.getMessageAuthor().getName() + " gave " + member.getName() + " a hug!");
		
		event.getChannel().sendMessage(embed);
		return;
	}

}
