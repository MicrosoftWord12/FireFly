package firefly.firefly.Events.LandClaiming;

import firefly.firefly.Commands.Utils.LandClaiming.BaseClaim;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collections;

public class onInteractEvent implements Listener {

    private final BaseClaim claim;

    public onInteractEvent(BaseClaim plugin){
        this.claim = plugin;
    }

    @EventHandler
    public void InteractEvent(PlayerInteractEvent e){
        try{
            if (!e.hasItem()) return;
            if (!e.getItem().hasItemMeta()) return;
            if (!e.getItem().getItemMeta().hasDisplayName()) return;
        }catch (NullPointerException ex){
            System.err.println(ex);
        }

//        String displayName = e.getItem().getItemMeta().getDisplayName();
//        if(displayName.toLowerCase().contains(Material.GOLDEN_AXE.toString())){
//            Player player = e.getPlayer();
//            Chunk chunk = player.getLocation().getChunk();
//            String chunkId = chunk.getX() + "." + chunk.getZ();
//            if (claim.isClaimed(chunkId, player)){
//                player.sendMessage(ChatColor.RED + "THIS LAND IS CLAIMED");
//            }else{
//                player.sendMessage(ChatColor.GREEN + "This land is not claimed");
//            }
//        }
        Player player = e.getPlayer();
        if (claim.isClaimed(this.claim.getChunkID(e.getPlayer()), e.getPlayer())){
            player.sendMessage(ChatColor.RED + "This is someone's claim");
            e.setCancelled(true);
        }



    }
}
