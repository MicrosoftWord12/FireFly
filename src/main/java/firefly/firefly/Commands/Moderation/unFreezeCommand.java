package firefly.firefly.Commands.Moderation;

import firefly.firefly.FireFly;
import firefly.firefly.PermissionEnums.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class unFreezeCommand implements CommandExecutor {
    private final FireFly plugin;
    
    public unFreezeCommand(FireFly plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);
            if (player.hasPermission(Permissions.FREEZE.name)){
                if (plugin.frozen.containsKey(target.getUniqueId())){
                    plugin.frozen.remove(target.getUniqueId());
                }else{
                    player.sendMessage(ChatColor.RED + " This person is not in the hashmap");
                }
            }else{
                player.sendMessage(ChatColor.RED + " You do not have the permission");
                System.err.println(player.getDisplayName() + " tried to use the unfreeze command");
            }
        }



        return true;
    }
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        if (sender instanceof Player){
//            Player player = (Player) sender;
//            if (player.hasPermission(Permissions.FREEZE.name)){
//                if (args.length < 1){
//                    player.sendMessage(ChatColor.RED + "YOU NEED TO GIVE A PLAYER");
//                }else{
//                    Player target = Bukkit.getPlayerExact(args[0]);
//                    try{
//                        System.out.println("Testing");
//                        plugin.frozen.put(target.getUniqueId(), target.getLocation());
//                    }catch (NullPointerException e){
//                        System.err.println(e);
//                    }
//                }
//            }else{
//                player.sendMessage(ChatColor.RED + "You do not have the correct perms");
//            }
//        }
//        return true;
//    }
}
