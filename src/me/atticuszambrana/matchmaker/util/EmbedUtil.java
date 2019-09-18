package me.atticuszambrana.matchmaker.util;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;

public class EmbedUtil {
	public static EmbedBuilder get(EmbedType type, String message) {
		if(type == EmbedType.ERROR) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setColor(Color.RED);
			embed.setDescription(message);
			return embed;
		}
		return null;
	}
	
	public enum EmbedType {
		ERROR;
	}
}
