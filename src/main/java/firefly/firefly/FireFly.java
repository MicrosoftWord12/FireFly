package firefly.firefly;

import firefly.firefly.Moderation.KickCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FireFly extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("kick")).setExecutor(new KickCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

