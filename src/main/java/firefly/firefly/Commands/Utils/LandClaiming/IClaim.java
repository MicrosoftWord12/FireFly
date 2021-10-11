package firefly.firefly.Commands.Utils.LandClaiming;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface IClaim {

    public void addClaim(List<String> chunk, UUID owner);
    public void removeClaim(String chunkID, UUID playerUUID);
    public void addPlayerToOwnerClaim(String chunkID, UUID owner, UUID target);
    public void removePlayerFromOwnedClaim(List<String> chunkID, UUID owner, UUID target);
    public boolean isOwner(String chunkID, UUID owner);
    public boolean isClaimed(List<String> chunkID, Player player);
    public Chunk getChunkPlayerIn(Player player);
    public List<String> getChunkID(Player player);

}
