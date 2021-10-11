package firefly.firefly;

//import firefly.firefly.Commands.Database.DBTableCmd;
//import firefly.firefly.Database.Database;
import firefly.firefly.Commands.Utils.ConfigFile.ConfigYML;
import firefly.firefly.Commands.Utils.LandClaiming.BaseClaim;
import firefly.firefly.Commands.LandClaiming.ClaimCommand;
import firefly.firefly.Commands.Moderation.*;
import firefly.firefly.Events.*;
import firefly.firefly.Commands.Misc.FeedCommand;
import firefly.firefly.Commands.Misc.HealCommand;
import firefly.firefly.Events.LandClaiming.onInteractEvent;
import firefly.firefly.Events.ModerationEvents.onChangeGamemode;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class FireFly extends JavaPlugin {


//    public HashMap<String, UUID> claimedLand;
    public HashMap<UUID, List<String>> claimedLand;
    public ConfigYML configYML;
    public BaseClaim baseClaim;



    @Override
    public void onEnable() {
        this.baseClaim = new BaseClaim(this);
        this.configYML = new ConfigYML();
        this.claimedLand = new HashMap<>();
        this.saveDefaultConfig();
//        this.baseClaim.chunkList = new ArrayList<>();
        this.configYML.reloadConfig();

        World world = Bukkit.getWorld("world");
        assert world != null;
        world.setDifficulty(Difficulty.EASY);
        world.setGameRule(GameRule.KEEP_INVENTORY, true);
        world.setSpawnLocation(-503, 64, -224);

        // Land claiming commands
        Objects.requireNonNull(getCommand("claim")).setExecutor(new ClaimCommand(new BaseClaim(this)));

        // Misc/Admin
        Objects.requireNonNull(getCommand("Invisible")).setExecutor(new InvisibleCommand());
        Objects.requireNonNull(getCommand("Feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(getCommand("Heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("Invulnerable")).setExecutor(new InvulnerableCommand());
        Objects.requireNonNull(getCommand("Kick")).setExecutor(new KickCommand());

//        getServer().getPluginManager().registerEvents(new onMove(this), this);
        getServer().getPluginManager().registerEvents(new onPlayerSignClick(), this);
        getServer().getPluginManager().registerEvents(new onPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new onPlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new onChangeGamemode(), this);
        getServer().getPluginManager().registerEvents(new onServerPing(), this);
        getServer().getPluginManager().registerEvents(new onInteractEvent(new BaseClaim(this)), this);

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "The " + getName() + ChatColor.RED + " Plugin is online");
    }

    @Override
    public void onDisable() {
        saveClaims();
//        this.configYML.getConfig().set("Test", "test222");
//        this.configYML.saveConfig();

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "The " + getName() + ChatColor.RED + " Plugin is offline");
    }

    public void saveClaims(){
//        for (Map.Entry<String, UUID> entry: claimedLand.entrySet()){
//            this.configYML.getConfig().set("Chunks." + String.format("%s", entry.getKey()) + ".Players", entry.getValue().toString());
//        }
        for (Map.Entry<UUID, List<String>> entry: claimedLand.entrySet()){
//            this.configYML.getConfig().set("Players." + String.format("%s", entry.getKey()) + ".Chunks", entry.getValue());
            this.configYML.getConfig().set("Players." + entry.getKey().toString() + ".Chunk", Arrays.toString(entry.getValue().toArray()));
        }
        this.saveConfig();
    }

}

