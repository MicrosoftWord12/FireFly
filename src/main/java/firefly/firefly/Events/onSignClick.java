package firefly.firefly.Events;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class onSignClick implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (e.getClickedBlock().getState() instanceof Sign){
                Player player = e.getPlayer();
                try{
                    Sign sign = (Sign)e.getClickedBlock().getState();
                    if (sign.getLine(0).equals("[BUY]")){
                        System.out.println(Material.getMaterial(sign.getLine(1)));
                        System.out.println(Material.getMaterial(sign.getLine(3)));
                        Inventory inv = player.getInventory();
                        ItemStack itemToAdd = new ItemStack(Material.getMaterial(sign.getLine(1).toUpperCase()),  Integer.parseInt(sign.getLine(2)));
                        ItemStack itemToRemove = new ItemStack(Material.getMaterial(sign.getLine(3)), Integer.parseInt(sign.getLine(2)));

                        if (!inv.getContents().equals(itemToRemove)){
                            if (inv.containsAtLeast(itemToRemove, Integer.parseInt(sign.getLine(2)))){
                                inv.removeItem(itemToRemove);
                                inv.addItem(itemToAdd);
                            }
                        }else{
                            player.sendMessage("You cannot do this transaction");
                        }

                    }
                }catch (Exception ex){
                    player.sendMessage("The item on the sign is not an actual item");
                    player.sendMessage("Talk to God about it");
                }

            }
        }
    }


}
