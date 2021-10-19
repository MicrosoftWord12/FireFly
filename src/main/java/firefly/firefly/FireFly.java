package firefly.firefly;

//import firefly.firefly.Commands.Database.DBTableCmd;
//import firefly.firefly.Database.Database;
import firefly.firefly.Commands.ItemSpawning.CreateCocaine;
import firefly.firefly.Commands.ItemSpawning.CreateSpeedBook;
import firefly.firefly.Commands.ItemSpawning.CreateWeed;
import firefly.firefly.Commands.Utils.ConfigYML;
import firefly.firefly.Commands.Moderation.*;
import firefly.firefly.Events.*;
import firefly.firefly.Commands.Misc.FeedCommand;
import firefly.firefly.Commands.Misc.HealCommand;
import firefly.firefly.Events.ModerationEvents.onChangeGamemode;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class FireFly extends JavaPlugin {


    public ConfigYML configYML;



    @Override
    public void onEnable() {
        this.configYML = new ConfigYML();
        this.saveDefaultConfig();
//        this.baseClaim.chunkList = new ArrayList<>();
        this.configYML.reloadConfig();

        World world = Bukkit.getWorld("world");
//        assert world != null;
        world.setDifficulty(Difficulty.EASY);
        world.setGameRule(GameRule.KEEP_INVENTORY, true);
        world.setSpawnLocation(-503, 64, -224);
        // Items
        CreateCocaine.init();
        CreateWeed.init();
        CreateSpeedBook.init();

        // Misc/Admin
        Objects.requireNonNull(getCommand("Invisible")).setExecutor(new InvisibleCommand());
        Objects.requireNonNull(getCommand("Feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(getCommand("Heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("Invulnerable")).setExecutor(new InvulnerableCommand());
        Objects.requireNonNull(getCommand("Kick")).setExecutor(new KickCommand());

//        getServer().getPluginManager().registerEvents(new onMove(this), this);
        getServer().getPluginManager().registerEvents(new onSignClick(), this);
        getServer().getPluginManager().registerEvents(new onPlayerSignClick(), this);
        getServer().getPluginManager().registerEvents(new onPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new onPlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new onChangeGamemode(), this);
        getServer().getPluginManager().registerEvents(new onServerPing(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "The " + getName() + ChatColor.RED + " Plugin is online");
    }

    @Override
    public void onDisable() {
//        this.configYML.getConfig().set("Test", "test222");
//        this.configYML.saveConfig();

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "The " + getName() + ChatColor.RED + " Plugin is offline");
    }
}

