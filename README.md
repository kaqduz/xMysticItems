# xMysticItems

Add custom, mitical items to your server!

### Installing

Download latest version above, and simply put in in "plugins" folder

## API

xMysticItems provides API for making your own Mystic Item.

### Using API

Firstly you need to get instance of xMysticItems plugin through PluginManager in your main plugin class

```
public Plugin getxMysticItems() {
      return getServer().getPluginManager().getPlugin("xMysticItems");
    }
```

Then you have to get manager variable in the same class


```
public MysticItemManager manager(){


return getxMysticItems().manager;

}
```
You can now create new item class, remember it must extend "MysticItem" class
You need to know, what type of item will be your MysticItem.
Plugin allows to use 5 types of items:

```
USABLE when item will be based on "right click use",
ATTACKABLE when item will be based on attack effects i.e burn, hurt etc,
DEFENDABLE when item will be based on defend effects i.e damage-block, damage-reduction etc,
DEATHACCESSABLE when item will access death event i.e instant respawn, lighting effect after death etc ,
CUSTOM with this type you can do everything based on Bukkit;



```
Remember that MysticItem base class implements listener so u can use Event Handler 


```
public class Dagger extends MysticItem {

	public Dagger(MysticItemManager instance) {
        //Here you can explain item's material, and MysticItemType
        super(itemek(new ItemStack(Material.WOOD_SWORD)), instance, MysticItemType.ATTACKABLE);

}

//Here u can explain what lore, name or enchantments will have
static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§7Dagger");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oDagger ideal for trimming the throat. ");
    lore.add("§8Poison I effect - duration: §63 seconds");
    lore.add("§8Fire effect - duration: §63 seconds");
    meta.setLore(lore);
    ItemStack i = metaa;
    i.setItemMeta(meta);
    return i;
}


```
Usable items calls void "onUse(PlayerInteractEvent e)" when used  ;
Attackable items calls voids "onAttack(EntityDamageByEntityEvent e) and onAttackPassive(EntityDamageByEntityEvent e)" when player attacked someone ;
Defendable items calls voids "onDefend(EntityDamageEvent e) and onDeffendPassive(EntityDamageEvent e)" when player gets any damage;
DeathAccessable items calls void "onDeath(PlayerDeathEvent e)" when player dies with item;

In those voids u can do everthing you want with event.





## Deployment

Add additional notes about how to deploy this on a live system


## Authors

* ** [kaqduz](https://github.com/kaqduz) ** *

See also the list of [contributors](https://github.com/kaqduz/xMysticItems/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## README.md template [from](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
