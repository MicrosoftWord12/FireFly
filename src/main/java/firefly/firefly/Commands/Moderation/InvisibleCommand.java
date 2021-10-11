package firefly.firefly.Commands.Moderation;

import firefly.firefly.Enums.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvisibleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;

            if (player.hasPermission(Permissions.INVISIBLE.name)){
                if (args.length == 0){
                    if (!player.isInvisible()){
                        player.setInvisible(true);
                        player.sendMessage(ChatColor.RED + player.getDisplayName() + " Is now invisible to players");
                    }else if (player.isInvisible()){
                        player.sendMessage(ChatColor.RED + player.getDisplayName() + " can now be seen to players");
                        player.setInvisible(false);
                    }
                }else if (args.length == 1){
                    Player target = Bukkit.getPlayerExact(args[0]);
                    assert target != null;
                    if (!target.isInvisible()){
                        target.setInvisible(true);
                        target.sendMessage(ChatColor.RED + player.getDisplayName() + " Is now invisible to players");

                    }else if (target.isInvisible()){
                        target.sendMessage(ChatColor.RED + player.getDisplayName() + " can now be seen to players");
                        target.setInvisible(false);
                    }
                }

            }else{
                player.sendMessage(ChatColor.RED + "You do not have the permissions");
            }
        }else{
            System.err.println("YOU ARE NOT A PLAYER && CONSOLE CANNOT USE THIS COMMAND " + command.getName());
        }
        return false;
    }
}
