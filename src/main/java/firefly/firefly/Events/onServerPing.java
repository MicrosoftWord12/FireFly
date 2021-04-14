package firefly.firefly.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

public class onServerPing implements Listener {

    @EventHandler
    public void serverPing(ServerListPingEvent e){
        try{
            e.setMaxPlayers(25);
            e.setMotd(ChatColor.YELLOW + "This is a private server" + "\n" + ChatColor.RED + "For my Friends");
            e.setServerIcon(Bukkit.loadServerIcon(new File("icon.png")));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
