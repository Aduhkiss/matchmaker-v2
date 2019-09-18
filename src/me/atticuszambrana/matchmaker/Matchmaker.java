package me.atticuszambrana.matchmaker;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import me.atticuszambrana.matchmaker.command.CommandCenter;
import me.atticuszambrana.matchmaker.common.Config;
import me.atticuszambrana.matchmaker.manager.ConfigManager;

public class Matchmaker {
	
	DiscordApi api;
	Config config;
	
	// Managers
	ConfigManager configManager;
	
	public Matchmaker() {
		registerManagers();
		config = configManager.getConfig();
		startAPI();
	}
	
	private void registerManagers() {
		configManager = new ConfigManager(this);
	}
	
	private void startAPI() {
		api = new DiscordApiBuilder()
				.setToken(config.getToken())
				.addListener(new CommandCenter(this))
				.login()
				.join();
	}
	
	public DiscordApi getAPI() {
		return api;
	}
	
	public Config getConfig() {
		return config;
	}

}
