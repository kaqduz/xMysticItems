package com.kaqduz.xMysticItems.Item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public abstract class MysticItem implements Listener {
	
public  void onUse(PlayerInteractEvent e)  {
}
public  void onAttack(EntityDamageByEntityEvent e) {
}
public  void onDefend(EntityDamageEvent e) {
}
public  void onDeath(PlayerDeathEvent e) {
}
public void onAttackPassive(EntityDamageByEntityEvent e) {	
}
public void onDeffendPassive(EntityDamageEvent e){	
}

	public enum MysticItemType {
	
	
	USABLE(0), ATTACKABLE(1), DEFENDABLE(2), DEATHACCESSABLE(3), CUSTOM(4);
	private int value;
	private MysticItemType(int i){
		this.value = i;		
		
	}
	
	
	}
	MysticItemType type;
	
	ItemStack itemstack;
	MysticItemManager instance;
	boolean usable = false;
	boolean attackable = false;
	boolean defendable = false;
	boolean deathacessable = false;
	public MysticItem(ItemStack item, MysticItemManager Instance,  MysticItemType... t){
		if(item != null && Instance != null){
		itemstack = item;
		instance = Instance;
		
		for (MysticItemType type : t){
		if(type.value == 0)
			usable = true;
		if(type.value == 1)
			attackable = true;
		if(type.value == 2)
			defendable = true;
		if(type.value == 3)
			deathacessable = true;
		
		}
		
		}else
		throw new NullPointerException("Item is null");
				
		
	}
	
	
	@EventHandler
	public void onUseItem(PlayerInteractEvent e) throws Exception{

		if(usable &&  (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().hasItemMeta() &&  e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(itemstack.getItemMeta().getDisplayName()) && e.getClickedBlock().getType() != Material.CHEST && e.getClickedBlock().getType() != Material.ENDER_CHEST && e.getClickedBlock().getType() != Material.STONE_BUTTON && e.getClickedBlock().getType() != Material.WOOD_BUTTON && e.getClickedBlock().getType() != Material.BED_BLOCK && e.getClickedBlock().getType() != Material.BOAT && e.getClickedBlock().getType() != Material.BEACON && e.getClickedBlock().getType() != Material.BREWING_STAND && e.getClickedBlock().getType() != Material.BURNING_FURNACE && e.getClickedBlock().getType() != Material.FURNACE && e.getClickedBlock().getType() != Material.WORKBENCH) || e.getAction() == Action.RIGHT_CLICK_AIR ){
			e.setCancelled(true);
		onUse(e);
		}
	}
	@EventHandler
	public void onAttackItem(EntityDamageEvent e){
		
		if(e instanceof EntityDamageByEntityEvent){
			if(((EntityDamageByEntityEvent) e).getDamager() instanceof Player){
		Player attacker = (Player) ((EntityDamageByEntityEvent) e).getDamager();
		if(attackable && attacker.getItemInHand() != null && attacker.getItemInHand().hasItemMeta() && attacker.getItemInHand().getItemMeta().getDisplayName() != null &&  attacker.getItemInHand().getItemMeta().getDisplayName().equals(itemstack.getItemMeta().getDisplayName()))
		onAttack((EntityDamageByEntityEvent)e);
		
		}
		}
		if (e.getEntity() instanceof Player){
		Player defender = (Player) e.getEntity();
		if(defendable && defender.getItemInHand() != null && defender.getItemInHand().hasItemMeta() && defender.getItemInHand().getItemMeta().getDisplayName() != null &&  defender.getItemInHand().getItemMeta().getDisplayName().equals(itemstack.getItemMeta().getDisplayName())){
			onDefend(e);
			
		}
		}
		
	}
	@EventHandler
	public void onDeathPlayer(PlayerDeathEvent e){
		if(deathacessable && instance.getPlugin().PlayerHasItem(e.getEntity(), itemstack))
			onDeath(e);
		
	}
	public ItemStack getItem(){
		if(itemstack != null)
		return itemstack;
		return null;
		
	}
	@EventHandler
	public void onAttackWithoutItem(EntityDamageEvent e) throws Exception{
		if(e instanceof EntityDamageByEntityEvent){
			if(((EntityDamageByEntityEvent) e).getDamager() instanceof Player){
				
		Player attacker = (Player) ((EntityDamageByEntityEvent) e).getDamager();
		
		if(attackable && instance.getPlugin().PlayerHasItem(attacker, itemstack)){
			
			onAttackPassive((EntityDamageByEntityEvent) e);
			
			
		}
		
			}
		}
		if (e.getEntity() instanceof Player) {
			Player victim = (Player) e.getEntity();
			if(defendable && instance.getPlugin().PlayerHasItem(victim, itemstack)){
				onDeffendPassive(e);
				
			}
		}
		
		
	}
	
	
		
	
	
	
	
	
	
}
