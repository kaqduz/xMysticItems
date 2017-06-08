package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class DarkMainer extends MysticItem {

	public DarkMainer(MysticItemManager instance) {
        
        super(itemek(new ItemStack(Material.DIAMOND_PICKAXE)), instance, MysticItemType.USABLE);

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§5§kab§r§5§lDark Mainer§kbm");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oThe fastest known pickaxe. Destroys and collects blocks near to you");
    lore.add("§8Break - radius: §63 blocks");
    lore.add("§aEach use destroys the item by 10%.");
    lore.add("§aBlocks under player will not be destroyed.");
    meta.addEnchant(Enchantment.DURABILITY, 6, true);
    meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 6, true);
    meta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
    
    meta.setLore(lore);
    ItemStack i = metaa;
    i.setItemMeta(meta);
    return i;
}




@Override
public void onUse(final PlayerInteractEvent e){
		List<Block> blocks = getNearbyBlocks(e.getPlayer().getLocation(), 3);
		for(final Block b : blocks){
			if(b.getLocation().getBlockY() > e.getPlayer().getLocation().getBlockY() - 1 && b.getType() != Material.AIR && b.getType() != Material.WATER && b.getType() != Material.LAVA && b.getType() != Material.BEDROCK && b.getType() != Material.OBSIDIAN && b.getType() != Material.STATIONARY_WATER && b.getType() != Material.STATIONARY_LAVA){
				new BukkitRunnable(){
	        	    @Override
	        	    public void run(){
	        	    	
	        	    	if(b.getType() != Material.STONE)
	        				e.getPlayer().getWorld().dropItem(e.getPlayer().getLocation(), new ItemStack(b.getType()));
	        				if(b.getType() != Material.CHEST)
	        				b.setType(Material.AIR);
	        				else b.breakNaturally();

	        	    }
	        	    }.runTaskLater(instance.getPlugin(), 5);
				
				
				
				
			}
			
			
			
		}
		e.getPlayer().getItemInHand().setDurability((short) (e.getPlayer().getItemInHand().getDurability() + e.getPlayer().getItemInHand().getType().getMaxDurability() * 0.1));
		if(e.getPlayer().getItemInHand().getDurability() >= e.getPlayer().getItemInHand().getType().getMaxDurability() - 1){
			e.getPlayer().setItemInHand(new ItemStack(Material.AIR));						
		}
		e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.EXPLODE, 1F, 1F);
		
	
}


@Override
public void onDefend(EntityDamageEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void onDeath(PlayerDeathEvent e) {
	// TODO Auto-generated method stub
	
}
public static List<Block> getNearbyBlocks(Location location, int radius) {
    List<Block> blocks = new ArrayList<Block>();
    for(int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
        for(int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
            for(int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
               blocks.add(location.getWorld().getBlockAt(x, y, z));
            }
        }
    }
    return blocks;
}
	
	
}
