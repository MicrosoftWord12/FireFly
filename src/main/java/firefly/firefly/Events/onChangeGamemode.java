package firefly.firefly.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class onChangeGamemode implements Listener {

    @EventHandler
    public void playerChangeEvent(PlayerGameModeChangeEvent e){
        Player player = e.getPlayer();
        System.out.println(player.getDisplayName() + " Changed their gamemode to " + e.getNewGameMode());
    }


}
