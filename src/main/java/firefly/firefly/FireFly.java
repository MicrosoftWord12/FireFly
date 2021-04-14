package firefly.firefly;

import firefly.firefly.Events.*;
import firefly.firefly.Misc.FeedCommand;
import firefly.firefly.Misc.HealCommand;
import firefly.firefly.Moderation.InvisibleCommand;
import firefly.firefly.Moderation.InvulnerableCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class FireFly extends JavaPlugin {

    @Override
    public void onEnable() {

//        Enabling commands

//        getCommand("Kick").setExecutor(new KickCommand());
        getCommand("Invisible").setExecutor(new InvisibleCommand());
        getCommand("Feed").setExecutor(new FeedCommand());
        getCommand("Heal").setExecutor(new HealCommand());
        getCommand("Invulnerable").setExecutor(new InvulnerableCommand());

        getServer().getPluginManager().registerEvents(new onPlayerSignClick(), this);
        getServer().getPluginManager().registerEvents(new onPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new onPlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new onChangeGamemode(), this);
        getServer().getPluginManager().registerEvents(new onServerPing(), this);


        System.out.println(getName() + " Is Online");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "The " + getName() + ChatColor.RED + " Plugin is online");

    }

    @Override
    public void onDisable() {
        System.out.println(getName() + "Is Offline");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "The " + getName() + ChatColor.RED + " Plugin is offline");
    }
}

