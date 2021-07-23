package firefly.firefly.Events.ModerationEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class onPlayerKick implements Listener {

    @EventHandler
    public void playerKick(PlayerKickEvent e){
        Bukkit.getServer().broadcastMessage(e.getPlayer() + "has been kicked." + ChatColor.RED + "The reason was" + e.getReason());
    }


}
