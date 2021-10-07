package firefly.firefly;

//import firefly.firefly.Commands.Database.DBTableCmd;
//import firefly.firefly.Database.Database;
import firefly.firefly.Commands.LandClaiming.Claim;
import firefly.firefly.Commands.Moderation.*;
import firefly.firefly.Events.*;
import firefly.firefly.Commands.Misc.FeedCommand;
import firefly.firefly.Commands.Misc.HealCommand;
import firefly.firefly.Events.LandClaiming.onInteractEvent;
import firefly.firefly.Events.ModerationEvents.onChangeGamemode;
import firefly.firefly.Events.ModerationEvents.onMove;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public final class FireFly extends JavaPlugin {


    public HashMap<String, UUID> chunks;
    public HashMap<UUID, Location> frozen;

    @Override
    public void onEnable() {
//        Enabling commands

//        Database.initDB();
        this.chunks = new HashMap<>();
        this.frozen = new HashMap<>();

        World world = Bukkit.getWorld("world");
        assert world != null;
        world.setDifficulty(Difficulty.EASY);
        world.setGameRule(GameRule.KEEP_INVENTORY, true);
        world.setSpawnLocation(-503, 64, -224);

//        System.out.println("Claimed tool");
//        try{
//            Objects.requireNonNull(getCommand("unfreeze")).setExecutor(new unFreezeCommand(this));
//        }catch (NullPointerException ex){
//            System.err.println(ex);
//        }
        Objects.requireNonNull(getCommand("freeze")).setExecutor(new FreezeCommand(this));
        Objects.requireNonNull(getCommand("claim")).setExecutor(new ClaimCommand(this));
        Objects.requireNonNull(getCommand("removeClaim")).setExecutor(new RemovePlayerFromChunk(this));
        Objects.requireNonNull(getCommand("addPlayerToClaim")).setExecutor(new AddPlayerToChunk(this));
        Objects.requireNonNull(getCommand("Invisible")).setExecutor(new InvisibleCommand());
        Objects.requireNonNull(getCommand("Feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(getCommand("Heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("Invulnerable")).setExecutor(new InvulnerableCommand());
        Objects.requireNonNull(getCommand("Kick")).setExecutor(new KickCommand());

//        getCommand("DBinit").setExecutor(new DBTableCmd());

        getServer().getPluginManager().registerEvents(new onMove(this), this);
        getServer().getPluginManager().registerEvents(new onPlayerSignClick(), this);
        getServer().getPluginManager().registerEvents(new onPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new onPlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new onChangeGamemode(), this);
        getServer().getPluginManager().registerEvents(new onServerPing(), this);
        getServer().getPluginManager().registerEvents(new onInteractEvent(new Claim()), this);

//        System.out.println(getName() + " Is Online");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "The " + getName() + ChatColor.RED + " Plugin is online");
    }

    @Override
    public void onDisable() {
//        System.out.println(getName() + "Is Offline");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "The " + getName() + ChatColor.RED + " Plugin is offline");
    }

//    public void addChunk(String chunk, UUID owner){
//        chunks.put(chunk, owner);
//    }
//    public void removeChunk(String chunk, UUID owner){chunks.remove(chunk, owner);}
//    public boolean isChunk(String chunk){
//        return chunks.containsKey(chunk);
//    }
//    public UUID getOwner(String chunk){
//        return chunks.get(chunk);
//    }
//    public void addPlayerToChunk(String chunkID, UUID opponent, UUID owner ){
//        chunks.put(chunkID, opponent);
//    }
//    public void removePlayerFromChunk(String chunkID, UUID player){
//        chunks.remove(chunkID, player);
//    }

}

