package firefly.firefly.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onPlayerLeave implements Listener {

    @EventHandler
    public void playerLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        e.setQuitMessage(player.getDisplayName() + ChatColor.RED + " Has Left the Server");
    }


}
