package firefly.firefly.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class onPlayerSignClick implements Listener {
    public Inventory signInv = Bukkit.createInventory(null, 9, "Sign Inventory");


    @EventHandler
    public void onSignInteract(PlayerInteractEvent e){
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && Objects.requireNonNull(e.getClickedBlock()).getState() instanceof Sign){
            Sign sign = (Sign) e.getClickedBlock().getState();
            if (sign.getLine(0).equalsIgnoreCase("key")){
                addSignInvItems();
                e.getPlayer().openInventory(signInv);
            }
        }
    }

    public void addSignInvItems(){
//        Making Button
        ItemStack button = new ItemStack(Material.OAK_BUTTON, 1);

//        Changing Item Meta Information
        ItemMeta meta = button.getItemMeta();

        assert meta != null;

        meta.setDisplayName("Room Key");

//        Setting Item in Sign INV
        signInv.addItem(button);
    }

    //    Database Connected Room -> player
}
