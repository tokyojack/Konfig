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
				//Creates a .yml file with the name "test"
				.addConfigFile(new ConfigFile("test")
						.setString("noice", "hello") // Sets a string with a name "noice" and a value: "hello"
						.setInteger("ayy", 123) // Sets a int with a name "ayy" and a value: "123"
						.setBoolean("is.tokyojack.hot", true)) // Sets a boolean with a name "ayy.tokyojack.hot" and a value: "123"
				.addConfigFile(new ConfigFile("lang")  //Creates a .yml file with the name "lang"
						.set("amount", 1) // Sets a int with the name "amount" and a value: "1"
						.set("command.message", "Cool command :^)") // Sets a string with the name "command.message" and a value: "Cool command :^)"
						.set("command.noPerm", "You don't have any perms for that command!")) // Sets a string with the name "command.noPerm" and a value: 
																							  // "You don't have any perms for that command!"
				.build(); //You must ALWAYS add this to the end to create the files
				
				//NOTE: Having the dots will indent it into section. Ex:
				//------
				//amount: 1
				//command:
				//  message: 'Cool command my guy:^)'
				//  noPerm: 'You don't have any perms for that command!'
				//------

		//Registers the event below
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onEntityDamage(BlockBreakEvent event) {
		//This is just an example

		//NOTE: when getting a value, you don't need to say what file it's from, only the same location

		Bukkit.broadcastMessage(konfig.getString("noice") + " | "
				+ konfig.getInteger("ayy") + " | "
				+ konfig.getBoolean("is.tokyojack.hot"));

		Bukkit.broadcastMessage(konfig.getInteger("amount") + " | "
				+ konfig.getString("command.message") + " | "
				+ konfig.getString("command.noPerm"));
		
	}
}
