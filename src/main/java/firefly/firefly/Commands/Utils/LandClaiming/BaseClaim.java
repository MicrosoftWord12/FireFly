package firefly.firefly.Commands.Utils.LandClaiming;

import firefly.firefly.FireFly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BaseClaim implements IClaim {

    public final FireFly plugin;
    public List<String> chunkList;

    public BaseClaim(FireFly plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean isClaimed(List<String> chunkID, Player player) {
        if ((plugin.claimedLand.containsKey(player.getUniqueId()) && plugin.claimedLand.containsValue(chunkID))){
            if (isOwner(chunkID.toString(), player.getUniqueId())){
                player.sendMessage(ChatColor.RED + "This is your land");
                return true;
            }
            return false;
            // oi dickhead this is why your claim command code isn't working
        }else{
            return false;
        }

    }
    @Override
    public boolean isOwner(String chunkID, UUID owner) {
        if (this.plugin.claimedLand.get(owner).equals(chunkID)){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void addClaim(List<String> chunk, UUID ownersUUID) {
        plugin.claimedLand.put(ownersUUID, chunk);
        try{
//            this.plugin.configYML.getConfig().set("Players." + ownersUUID.toString() + ".Chunk", chunk.toArray());
//            this.plugin.configYML.getConfig().set("Players." + ownersUUID.toString() + ".Chunk", chunk);
            this.plugin.configYML.getConfig().set("Players." + ownersUUID.toString() + ".Chunk", chunk);
            this.plugin.configYML.saveConfig();
            this.plugin.saveClaims();



        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void removeClaim(String chunkID, UUID ownersUUID) {
            plugin.claimedLand.remove(chunkID, ownersUUID);
            plugin.configYML.getConfig().set("Chunks." + chunkID + ".Players", null);
    }
    @Override
    public void addPlayerToOwnerClaim(String chunkID, UUID owner, UUID target) {
        if (isOwner(chunkID, owner)){
            if (plugin.claimedLand.containsKey(chunkID) && plugin.claimedLand.containsValue(owner)){
//                plugin.claimedLand.put(chunkID, owner);
                plugin.claimedLand.put(owner, Collections.singletonList(chunkID));
            }
        }
    }
    @Override
    public void removePlayerFromOwnedClaim(List<String> chunkID, UUID owner, UUID target) {
        if (isOwner(chunkID.toString(), owner)){
            if (plugin.claimedLand.containsKey(chunkID.toString()) && plugin.claimedLand.containsValue(owner)){
                plugin.claimedLand.remove(chunkID, target);
            }
        }
    }
    @Override
    public Chunk getChunkPlayerIn(Player player) {
        return player.getLocation().getChunk();
    }
    @Override
    public List<String> getChunkID(Player player) {
//        String chunkID = getChunkPlayerIn(player).getX() + "." + getChunkPlayerIn(player).getZ();
        return Collections.singletonList(String.format("%s%s.", getChunkPlayerIn(player).getX(), getChunkPlayerIn(player).getZ()));

    }
}
