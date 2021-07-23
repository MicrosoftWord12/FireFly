package firefly.firefly;

//import firefly.firefly.Commands.Database.DBTableCmd;
//import firefly.firefly.Database.Database;
import firefly.firefly.Events.*;
import firefly.firefly.Commands.Misc.FeedCommand;
import firefly.firefly.Commands.Misc.HealCommand;
import firefly.firefly.Commands.Moderation.InvisibleCommand;
import firefly.firefly.Commands.Moderation.InvulnerableCommand;
import firefly.firefly.Commands.Moderation.KickCommand;
import firefly.firefly.Events.ModerationEvents.onChangeGamemode;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FireFly extends JavaPlugin {

    @Override
    public void onEnable() {
//        Enabling commands

//        Database.initDB();

        World world = Bukkit.getWorld("world");
        assert world != null;
        world.setDifficulty(Difficulty.PEACEFUL);
        world.setGameRule(GameRule.KEEP_INVENTORY, true);
        world.setSpawnLocation(-503, 64, -224);

        Objects.requireNonNull(getCommand("Invisible")).setExecutor(new InvisibleCommand());
        Objects.requireNonNull(getCommand("Feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(getCommand("Heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("Invulnerable")).setExecutor(new InvulnerableCommand());
        Objects.requireNonNull(getCommand("Kick")).setExecutor(new KickCommand());
//        getCommand("DBinit").setExecutor(new DBTableCmd());

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

