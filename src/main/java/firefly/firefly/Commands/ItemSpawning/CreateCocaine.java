package firefly.firefly.Commands.ItemSpawning;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CreateCocaine {

    public static ItemStack coke;

    public static void init(){
        createCoke();
    }


    private static void createCoke(){
        ItemStack item = new ItemStack(Material.SUGAR, 10);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("&cCocaine&c");
        List<String> lore = new ArrayList<>();
        lore.add("You know what it is... I know what it is");
        lore.add("ITS D.D.D.DRUGGGGSSSSS");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("coke"), item);
        recipe.shape("SBS");
        recipe.setIngredient('S', Material.SUGAR);
        recipe.setIngredient('B', Material.BLAZE_POWDER);
        Bukkit.getServer().addRecipe(recipe);
        coke = item;
    }



}
