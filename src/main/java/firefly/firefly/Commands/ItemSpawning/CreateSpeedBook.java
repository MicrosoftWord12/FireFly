package firefly.firefly.Commands.ItemSpawning;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CreateSpeedBook {

    public static ItemStack item;

    public static void init(){
        createSpeedBook();
    }

    public static void createSpeedBook(){
        ItemStack speedItem = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta speedItemMeta = speedItem.getItemMeta();
        List<String> speedItemLore = new ArrayList<>();
        speedItemLore.add("YOU ARE SPEED MY PERSON");

        speedItemMeta.setDisplayName("&aSpeed II");
        speedItemMeta.addEnchant(Enchantment.LUCK, 1, true);
        speedItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        speedItemMeta.setLore(speedItemLore);
        speedItem.setItemMeta(speedItemMeta);
        item = speedItem;

        ShapedRecipe speedRecipe = new ShapedRecipe(NamespacedKey.minecraft("speed_book"), speedItem);
        speedRecipe.shape("CSC");
        speedRecipe.setIngredient('s', getSpeedBook().getType());
        speedRecipe.setIngredient('c', CreateCocaine.getCoke().getType());
        Bukkit.getServer().addRecipe(speedRecipe);

    }

    public static ItemStack getSpeedBook(){
        return item;
    }


}
