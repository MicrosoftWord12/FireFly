package firefly.firefly.Commands.LandClaiming;

import firefly.firefly.FireFly;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Claim implements IClaim {

    HashMap<String, UUID> claimedLand;

    @Override
    public boolean isClaim(String chunkID) {
        if (String isInMap; claimedLand.get(chunkID);){

        }
        return true;
    }

    public boolean getOwner(String chunkID, UUID owner) {
        return false;
    }

    public void addClaim(String chunk, UUID ownersUUID) {
        claimedLand.put(chunk, ownersUUID);
    }


    public void removeClaim(String chunkID, UUID playerUUID) {
        claimedLand.remove(chunkID, playerUUID);
    }


    public void addPlayerToOwnerClaim(String chunkID, UUID owner, UUID target) {
        if (getOwner(chunkID, owner)){
            if (claimedLand.containsKey(chunkID) && claimedLand.containsValue(owner)){
                claimedLand.put(chunkID, owner);
            }
        }
    }


    public void removePlayerFromOwnedClaim(String chunkID, UUID owner, UUID target) {
        if (getOwner(chunkID, owner)){
            if (claimedLand.containsKey(chunkID) && claimedLand.containsValue(owner)){
                claimedLand.remove(chunkID, target);
            }
        }
    }
}
