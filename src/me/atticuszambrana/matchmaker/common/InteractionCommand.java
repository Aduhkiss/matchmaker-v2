package me.atticuszambrana.matchmaker.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.matchmaker.command.Command;

public abstract class InteractionCommand extends Command {

	public InteractionCommand(String command, String description) {
		super(command, description);
		images = new ArrayList<String>();
	}
	
	private List<String> images;

	@Override
	public abstract void execute(MessageCreateEvent event);
	
	public void addImage(String url) {
		images.add(url);
	}
	
	public String getImage() {
		Random r = new Random();
		int i = r.nextInt(images.size());
		return images.get(i);
	}
	
}
