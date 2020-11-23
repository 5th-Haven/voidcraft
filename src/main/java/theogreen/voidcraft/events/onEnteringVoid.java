package theogreen.voidcraft.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public final class onEnteringVoid implements Listener {

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        //here is the code that will be run
        Location location = event.getEntity().getLocation();
        if (location.getY() < -64) {
            World void_world = Bukkit.getServer().getWorld("void_world");
            Location location1 = new Location(void_world, 0.0, 64.0, 0.0);
            event.getEntity().teleport(location1);
        }
    }
}
