package firefly.firefly.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoin implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        boolean hasPlayerJoined = e.getPlayer().hasPlayedBefore();
        if (hasPlayerJoined){
            e.setJoinMessage(ChatColor.GREEN + "Welcome back " + ChatColor.LIGHT_PURPLE + player.getDisplayName());
        }else {
            e.setJoinMessage(ChatColor.AQUA + "Welcome to the server!!!" + player.getDisplayName() + "have a good time!!!!");
        }
    }

}
