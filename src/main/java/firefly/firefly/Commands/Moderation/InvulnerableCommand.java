package firefly.firefly.Commands.Moderation;

import firefly.firefly.Enums.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvulnerableCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission(Permissions.INVULNERABLE.name)){
                if (args.length == 0){
                    if (!player.isInvulnerable()){
                        player.setInvulnerable(true);
                        player.sendMessage(ChatColor.RED + "YOU ARE TECHNICALLY IN GOD MODE");

                    }else if(player.isInvulnerable()){
                        player.setInvulnerable(false);
                        player.sendMessage(ChatColor.RED + "YOU ARE NOT IN GOD MODE ANYMORE");
                    }
                }
            }
        }


        return false;
    }
}
