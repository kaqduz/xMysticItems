package com.kaqduz.xMysticItems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.kaqduz.xMysticItems.Command.givemystic;
import com.kaqduz.xMysticItems.Event.RecipeCraft;
import com.kaqduz.xMysticItems.Item.Dagger;
import com.kaqduz.xMysticItems.Item.DarkMainer;
import com.kaqduz.xMysticItems.Item.Dominator;
import com.kaqduz.xMysticItems.Item.EnderGuard;
import com.kaqduz.xMysticItems.Item.GodArmor;
import com.kaqduz.xMysticItems.Item.HelmOfMadness;
import com.kaqduz.xMysticItems.Item.HornOfPlenty;
import com.kaqduz.xMysticItems.Item.LifeSplitter;
import com.kaqduz.xMysticItems.Item.MagicStick;
import com.kaqduz.xMysticItems.Item.MagicWand;
import com.kaqduz.xMysticItems.Item.MithirilArmor;
import com.kaqduz.xMysticItems.Item.MysticItem;
import com.kaqduz.xMysticItems.Item.NetherGuard;
import com.kaqduz.xMysticItems.Item.Refresher;
import com.kaqduz.xMysticItems.Item.Sange;
import com.kaqduz.xMysticItems.Item.SangeAndYasha;
import com.kaqduz.xMysticItems.Item.ShadowBow;
import com.kaqduz.xMysticItems.Item.Yasha;
import com.kaqduz.xMysticItems.Util.MysticItemManager;


public class xMysticItems extends JavaPlugin {

	Plugin plugin;
	public List<MysticItem> mysticitems = new ArrayList<MysticItem>();
	public MysticItemManager manager;
	public void onEnable() {
		plugin = this;
		manager = new MysticItemManager(this);
		manager.registerItem(
				new MagicStick(manager),
				new Dagger(manager),
				new MagicWand(manager),
				new Refresher(manager),
				new HornOfPlenty(manager),
				new Sange(manager),
				new Yasha(manager) ,
				new SangeAndYasha(manager),
				new GodArmor(manager),
				new MithirilArmor(manager),
				new NetherGuard(manager),
				new EnderGuard(manager),				
				new Dominator(manager),
				new LifeSplitter(manager),
				new DarkMainer(manager),
				new HelmOfMadness(manager),
				new ShadowBow(manager)
				);		
		registerEvents(this, new RecipeCraft(manager));
	    getCommand("givemystic").setExecutor(new givemystic(this));
	    ShapelessRecipe recipe = new ShapelessRecipe(new SangeAndYasha(manager).getItem());
       
        recipe.addIngredient(Material.GOLD_SWORD);
        recipe.addIngredient(Material.IRON_SWORD);
        
		getServer().addRecipe(recipe);
		ShapelessRecipe domi = new ShapelessRecipe(new Dominator(manager).getItem());
		domi.addIngredient(Material.DIAMOND_HELMET);
		domi.addIngredient(Material.NETHER_STAR);
		getServer().addRecipe(domi);
		getPlugin().getLogger().info("Added Sange&Yasha, Dominator recipe");
		}
		 
		public void onDisable() {
		plugin = null;
		 manager.unregisterAll();
		 
		}
		public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
			for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
			}
		}
		public Plugin getPlugin(){
			return plugin;
		}
		public MysticItemManager getItemManager(){
			
			return manager;
		}
		
		public boolean PlayerHasItem(Player p, ItemStack item){
			int u = 0;
			for (ItemStack i : p.getInventory().getContents()){
				
				if(item.hasItemMeta()){
					if(i != null &&  i.hasItemMeta() &&  i.getItemMeta().getDisplayName() != null &&  i.getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())){
						u++;
						
					}
					
				}
				else if (i.getType() == item.getType()){
					u++;
					
				}
				
			}
for (ItemStack i : p.getInventory().getArmorContents()){
				
				if(item.hasItemMeta()){
					if(i != null &&  i.hasItemMeta() &&  i.getItemMeta().getDisplayName()!= null && i.getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())){
						u++;
						
					}
					
				}
				else if (i.getType() == item.getType()){
					u++;
					
				}
				
			}
			if (u == 0)
				return false;
			else
				return true;
				
			
		}
	
}
