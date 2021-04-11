package firefly.firefly.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onPlayerMove implements Listener {

    @EventHandler
    public void PlayerMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        if (player.hasPermission("FireFly.PlayerMove")){
            e.setCancelled(false);
        }
    }
}
