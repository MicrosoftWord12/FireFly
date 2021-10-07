package firefly.firefly.Commands.LandClaiming;

import java.util.UUID;

public interface IClaim {

    public void addClaim(String chunk);
    public void removeClaim(String chunkID, UUID playerUUID);
    public void addPlayerToOwnerClaim(String chunkID, UUID owner, UUID target);
    public void removePlayerFromOwnedClaim(String chunkID, UUID owner, UUID target);
    public boolean getOwner(String chunkID, UUID owner);
    public boolean isClaim(String chunkID);

}
