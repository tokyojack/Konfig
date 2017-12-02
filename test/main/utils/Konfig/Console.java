package me.tokyojack.mcmarket.configtest;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/* @author tokyojack
 * Created by tokyojack
 * 
 * DON't REMOVE
 * 
 * GITHUB: https://github.com/tokyojack/Bukkit-Console-Logger
 * DISCORD: tokyojack#7353
 * 
 */

public enum Console {
	ERROR(ChatColor.RED + "[ERROR]"),
	SUCCESS(ChatColor.GREEN + "[SUCCESS]"),
	INFO(ChatColor.WHITE + "[INFO]");

	// Could get the JavaPlugin instance and then get the plugin name off the
	// config you want.
	private final String PLUGIN_NAME = ChatColor.GOLD + "[Konfig]";
	private String prefix;

	private Console(String prefix) {
		this.prefix = prefix;
	}

	public void log(Object... values) {
		Bukkit.getServer().getConsoleSender()
				.sendMessage(PLUGIN_NAME + " " + this.prefix + ": " + mergeAllValuesIntoString(values));
	}

	private String mergeAllValuesIntoString(Object[] objects) {
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.asList(objects).stream().forEach(value -> stringBuilder.append(value.toString() + " "));
		return stringBuilder.toString();
	}
}