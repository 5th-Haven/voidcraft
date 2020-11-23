package theogreen.voidcraft.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public final class breakBedrock implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        //here is the code that will be run
        Player player = event.getPlayer();
        Material inhand = event.getMaterial();
        Material mat_clickedblock = event.getClickedBlock().getType();

        //making the shard of bedrock
        ItemStack bedrock_shard = new ItemStack(Material.COAL);
        ItemMeta bs_meta = bedrock_shard.getItemMeta();
        //adding stuff to copy of meta
        ArrayList<String> lore = new ArrayList<>();
        lore.add("It's hard, heavy, and sharp");
        bs_meta.setLore(lore);
        bs_meta.setDisplayName("Bedrock Shard");
        //setting meta
        bedrock_shard.setItemMeta(bs_meta);

        if (event.getItem().getItemMeta().hasLore()){
            if (event.getItem().getItemMeta().getLore().contains("Mithral glows from its core")) {

                if (inhand == Material.DIAMOND_PICKAXE) {

                    if (mat_clickedblock == Material.BEDROCK) {
                        player.sendMessage(ChatColor.BOLD + "The hardstone cracks and shows the void below");
                        player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 3.0f, 0.5f);
                        event.getItem().setAmount(0);
                        event.getClickedBlock().setType(Material.AIR);

                        //giving shard of bedrock
                        player.getInventory().addItem(bedrock_shard);
                    }
                }

            }

        }



    }
}