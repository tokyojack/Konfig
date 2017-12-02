package me.tokyojack.mcmarket.configtest;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin implements Listener {

	private Konfig konfig;

	public void onEnable() {
		konfig = new Konfig(this)
				.addConfigFile(new ConfigFile("test")
						.setString("noice", "hello")
						.setInteger("ayy", 123)
						.setBoolean("is.tokyojack.hot", true))
				.addConfigFile(new ConfigFile("lang")
						.set("amount", 1)
						.set("command.message", "Cool command :^)")
						.set("command.noPerm", "You don't have any perms for that command!"))
				.build();
				
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onEntityDamage(BlockBreakEvent event) {
		//This is just an example

		Bukkit.broadcastMessage(konfig.getString("noice") + " | "
				+ konfig.getInteger("ayy") + " | "
				+ konfig.getBoolean("is.tokyojack.hot"));

		Bukkit.broadcastMessage(konfig.getInteger("amount") + " | "
				+ konfig.getString("command.message") + " | "
				+ konfig.getString("command.noPerm"));
		
	}
}
