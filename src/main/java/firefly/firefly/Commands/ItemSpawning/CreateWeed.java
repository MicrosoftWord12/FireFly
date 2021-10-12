package firefly.firefly.Commands.ItemSpawning;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CreateWeed {

    public static ItemStack weed;

    public static void init(){
        createWeed();
    }

    private static void createWeed(){
        ItemStack weedItem = new ItemStack(Material.GREEN_DYE, 1);
        ItemMeta weedInfo = weedItem.getItemMeta();
        assert weedInfo != null;
        weedInfo.setDisplayName("&aJoint");
        weedInfo.addEnchant(Enchantment.LUCK, 1, true);
        List<String> weedLore = new ArrayList<>();
        weedLore.add("This is da goooood shittttt");
        weedInfo.setLore(weedLore);
        weedItem.setItemMeta(weedInfo);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("weed"), weedItem);
        recipe.shape("PGP");
        recipe.setIngredient('P', Material.PAPER);
        recipe.setIngredient('G', Material.GREEN_DYE);

        Bukkit.getServer().addRecipe(recipe);
        weed = weedItem;
    }


}
