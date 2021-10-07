package firefly.firefly.Commands.LandClaiming;


import firefly.firefly.FireFly;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClaimCommand implements CommandExecutor {

    private final FireFly plugin;
    private final Claim claim;

    public ClaimCommand(FireFly plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
//            System.out.println("This is a test");
            Chunk chunk = player.getLocation().getChunk();

            String chunkId = chunk.getX() + "." + chunk.getZ();
//            plugin.getServer().getConsoleSender().sendMessage(chunkId + "This is a test");
            if (claim.isChunk(chunkId)){
                player.sendMessage("This chunk is already claimed");
            }else{
                claim.addChunk(chunkId, player.getUniqueId());
                player.sendMessage(ChatColor.GREEN + "Welcome to your new Chunk");
            }
        }
        return false;
    }


}
