package firefly.firefly.Events.Signs;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class onInteractEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Block clickedBlock = e.getClickedBlock();
            System.out.println("This is a test");
//            if (clickedBlock.getState() == sign){
                System.out.println("sign test");

                // signLines[0] buy/sell
                // signLines[1] block
                // signLines[2] amount
                // signLines[3] price


            Sign sign = (Sign) clickedBlock.getState();
            String[] signLines = sign.getLines();
            // buy/sell
            System.out.println("buy");
            if (signLines[0].equals("[BUY]")){
                // selling/sold block
                System.out.println("block being sold");
                //TODO: The server fails at this point signLines[1] should equal a block
                System.out.println(Material.getMaterial(String.valueOf(Material.valueOf(signLines[1]))));
                // what is on that line
                System.out.println(signLines[1]);
                if (signLines[1].equals(Material.getMaterial(signLines[1]))){

                    // Amount being sold
                    System.out.println("selling amount");
                    int signAmount = Integer.parseInt(signLines[2]);
                    // price
                    if (signLines[3].equals(Material.getMaterial(signLines[3]))){
                        System.out.println("wanting to vbuy");
                        // is the sign attached to a chest?
                        Block attached = e.getClickedBlock().getRelative(sign.getBlock().getFace(sign.getBlock()));
                        if (attached.getType() == Material.CHEST){
                            BlockState state = attached.getState();

                            // is it and instance of the type chest
                            if (state instanceof Chest){
                                Chest chest = (Chest) state;
                                Inventory chestInv = chest.getBlockInventory();

                                // does the chest contain the selling item
                                if (chestInv.contains(Material.valueOf(signLines[1]))){
                                    Player player = e.getPlayer();
                                    Inventory playerInv = player.getInventory();

                                    // does the player contain the buying item
                                    if (playerInv.contains(Material.valueOf(signLines[3]))){
                                        ItemStack priceItem = new ItemStack(Material.valueOf(signLines[3]), signAmount);
                                        playerInv.addItem(priceItem);
                                        chestInv.remove(priceItem);
                                    }
                                }
                            }

                        }

                    }
                }
            }

//            }return;
        }
    }

}
