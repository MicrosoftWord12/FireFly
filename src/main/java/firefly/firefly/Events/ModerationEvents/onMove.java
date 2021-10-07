package firefly.firefly.Events.ModerationEvents;

import firefly.firefly.Commands.Moderation.FreezeCommand;
import firefly.firefly.FireFly;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.UUID;

public class onMove implements Listener {
    FireFly plugin;

    public onMove(FireFly plugin){
        this.plugin = plugin;
    }



    @EventHandler
    public void move(PlayerMoveEvent e){
        if (!plugin.frozen.containsKey(e.getPlayer().getUniqueId())){
            e.setCancelled(false);
        }else if (plugin.frozen.containsKey(e.getPlayer().getUniqueId())){
            e.setCancelled(true);
            System.err.println(e.getPlayer().getDisplayName() + " Has been frozen");

        }
    }


}
