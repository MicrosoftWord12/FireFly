package firefly.firefly.Commands.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;


public class ConfigYML {

//    Data.yml
    private FileConfiguration dataConfig = null;
    private File configFile = null;


    public ConfigYML(){
//        Saves/initialises config,
        reloadConfig();
    }

    public void reloadConfig(){
        if (this.configFile == null){
            this.configFile = new File(Bukkit.getServer().getPluginManager().getPlugin("FireFly").getDataFolder(), "data.yml");
            if (!this.configFile.exists()){
                try{
                    if (configFile.createNewFile()){
                        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "The File has been loaded");
                    }else{
                        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "The File hasn't been loaded");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
    }

    public FileConfiguration get() {
        if (this.dataConfig == null){
            System.out.println("No Config file");
            this.reloadConfig();
        }
        return this.dataConfig;
    }

    public void saveConfig(){
        if (this.dataConfig == null || this.configFile == null){
            reloadConfig();
        }
        try{
            this.get().save(this.configFile);
        }catch (IOException e){
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, e);
        }
    }


}
