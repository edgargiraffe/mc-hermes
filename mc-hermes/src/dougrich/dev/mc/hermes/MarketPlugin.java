package dougrich.dev.mc.hermes;

import org.bukkit.plugin.java.JavaPlugin;

public class MarketPlugin extends JavaPlugin {

	public void onEnable() {
		this.getLogger().info("Hermes Market Plugin Enabled");
	}
	
	public void onDisable() {
		this.getLogger().info("Hermes Market Plugin Disabled");
	}
}
