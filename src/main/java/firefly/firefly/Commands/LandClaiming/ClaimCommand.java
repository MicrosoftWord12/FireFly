package firefly.firefly.Commands.LandClaiming;



import firefly.firefly.Commands.Utils.LandClaiming.BaseClaim;
import firefly.firefly.FireFly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClaimCommand implements CommandExecutor {

    private final BaseClaim claim;


    public ClaimCommand(BaseClaim claim){
        this.claim = claim;
    }



    public void addPlayerToClaim(String[] args, Player player){
        if (args.length == 4){
            Player target = Bukkit.getPlayerExact(args[3]);
            System.out.println(target.getDisplayName());
            claim.addClaim(claim.getChunkID(target), player.getUniqueId());
        }

    }

    public void removePlayerFromClaim(String[] args, Player owner){
        if (args.length == 4){
            Player target = Bukkit.getPlayerExact(args[3]);
            claim.removePlayerFromOwnedClaim(claim.getChunkID(owner), owner.getUniqueId(), target.getUniqueId());
        }
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;

            if(!claim.isClaimed(claim.getChunkID(player), player)){
                if (args.length == 1){
                    if (args[0].equalsIgnoreCase("add"))
                        player.sendMessage(ChatColor.GREEN + "Your land is claimed");
                    claim.addClaim(claim.getChunkID(player), player.getUniqueId());
                }
                if (args.length == 2){
                    if (args[0].equalsIgnoreCase("add"))
                        if (args[1].equalsIgnoreCase("player"))
                            addPlayerToClaim(args, player);

                    if (args[0].equalsIgnoreCase("remove"))
                        if (args[1].equalsIgnoreCase("player"))
                            removePlayerFromClaim(args, player);
                }
            }else{
                player.sendMessage("Apparantly its saved?");
            }
        }
        return true;
    }


}
