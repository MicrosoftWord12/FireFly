package firefly.firefly.Events.LandClaiming;

import firefly.firefly.Commands.LandClaiming.Claim;
import firefly.firefly.FireFly;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class onInteractEvent implements Listener {

    private final Claim claim;

    public onInteractEvent(Claim plugin){
        this.claim = plugin;
    }

    @EventHandler
    public void InteractEvent(PlayerInteractEvent e){
        Player player = e.getPlayer();

//        Getting the chunk information
        Chunk chunk = player.getLocation().getChunk();
        String chunkId = chunk.getX() + "." + chunk.getZ();




    }
}
