package firefly.firefly.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class onPlayerCommand implements Listener {
    @EventHandler
    public void playerCommand(PlayerCommandSendEvent e){
        Player player = e.getPlayer();
        if (player.hasPermission("FireFly.seeAvailableCommands"))
        System.out.println(player.getDisplayName() + " Now can see all the servers commands");
    }
}
