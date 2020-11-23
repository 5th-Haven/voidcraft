package theogreen.voidcraft;

import theogreen.voidcraft.events.breakBedrock;
import org.bukkit.plugin.java.JavaPlugin;
import theogreen.voidcraft.events.breakBedrock;
import theogreen.voidcraft.events.onEnteringVoid;

public final class Voidcraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new breakBedrock(), this);
        getServer().getPluginManager().registerEvents(new onEnteringVoid(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
