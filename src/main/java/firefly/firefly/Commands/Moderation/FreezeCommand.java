package firefly.firefly.Commands.Moderation;

import firefly.firefly.FireFly;
import firefly.firefly.PermissionEnums.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.data.type.Fire;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {

    FireFly plugin;

    public FreezeCommand(FireFly plugin){
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission(Permissions.FREEZE.name)){
                if (args.length < 1){
                    player.sendMessage(ChatColor.RED + "YOU NEED TO GIVE A PLAYER");
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    try{
                        System.out.println("Testing");
                        plugin.frozen.put(target.getUniqueId(), target.getLocation());
                    }catch (NullPointerException e){
                        System.err.println(e);
                    }
                }
            }else{
                player.sendMessage(ChatColor.RED + "You do not have the correct perms");
            }
        }
        return true;
    }
}
