package firefly.firefly.Commands.Moderation;

import firefly.firefly.PermissionEnums.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


// /kick <PLAYER> <REASON>

public class KickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
//            THE PERSON INITIATING THE KICK
            Player player = (Player) sender;
            if (player.hasPermission(Permissions.KICK_MEMBER.name))
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "You need to specify the person for the kick");
            }
//            TARGET PLAYER = args[0]
            Player target = Bukkit.getServer().getPlayerExact(args[0]);
            assert target != null;
            String reason = "Kicked by Admin";
            target.kickPlayer(reason);
            player.sendMessage(ChatColor.LIGHT_PURPLE + target.getDisplayName() + " Has been kicked from the server with the reason "+ ChatColor.GREEN + reason);
//            COLOURED CONSOLE
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + target.getDisplayName() + " " + ChatColor.GREEN + "Has been kicked from the server by " + ChatColor.GREEN + player.getDisplayName() + " For the reason " + ChatColor.YELLOW + reason);

        }else{
            System.out.println("You are in console, you have to be in game");
        }


        return false;
    }
}
