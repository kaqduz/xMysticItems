package com.kaqduz.xMysticItems.Command;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kaqduz.xMysticItems.xMysticItems;
import com.kaqduz.xMysticItems.Item.MysticItem;
public class givemystic implements CommandExecutor {
	xMysticItems instance;
	public givemystic(xMysticItems Instance){
		instance = Instance;
		
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player p = (Player) sender;
			if(sender.hasPermission("mystic.items") && sender instanceof Player){
				
				if(args.length == 0 || args[0].equals("all")){
					
		        
		       
		       
		       for (MysticItem a : instance.getItemManager().getMysticItems()){
		    	   
		    	   p.getInventory().addItem(a.getItem());
		    	   
		    	   
		    	   
		       }
			
			
			
		}
				else if(args.length == 1){
					
					String itemname = args[0];
					ArrayList<MysticItem> items = instance.getItemManager().getMysticItems();
					int i = 0;
					for (MysticItem a : items){
				    	   if(a.getItem().getItemMeta().getDisplayName().toLowerCase().contains(itemname.toLowerCase())){
				    	   p.getInventory().addItem(a.getItem());
				    	   p.sendMessage("§8Given item: §6§o" + a.getItem().getItemMeta().getDisplayName());
				    	   i++;
				    	   }
				    	   
				    	   
				       }
						if(i == 0){
							p.sendMessage("§cCould not find item: §6§o" + itemname);							
							
						}
					
				}
				else{
					
					p.sendMessage("§cUnknown command.");	
					
				}
		
			}
			else {
				
				p.sendMessage("§cYou don't have permissions to use this command.");
				
			}
			return true;
	}
	

}
