package firefly.firefly.Moderation;

import firefly.firefly.Permissions.KickPermission;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;

public class KickCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if(sender.hasPermission("FireFly.KickMember")){
                Player player = (Player) sender;
                if (args[0].equals(player.getDisplayName())){
                    if (args.length == 2){
                        player.kickPlayer(args[1]);

                    }
                }
            }
        }
        return false;
    }
}
