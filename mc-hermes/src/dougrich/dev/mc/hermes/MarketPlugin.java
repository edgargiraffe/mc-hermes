package dougrich.dev.mc.hermes;

import org.bukkit.plugin.java.JavaPlugin;

import dougrich.dev.mc.hermes.commands.ShopBaseCommandExecutor;

public class MarketPlugin extends JavaPlugin {

	public void onEnable() {
		this.getLogger().info("Hermes Market Plugin Enabled");
		
		this.getCommand("shop").setExecutor(new ShopBaseCommandExecutor());
	}
	
	public void onDisable() {
		this.getLogger().info("Hermes Market Plugin Disabled");
	}
}
