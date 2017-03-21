package gamedev.example;

import gamedev.example.block.ModBlocks;
import gamedev.example.item.ModItems;
import gamedev.example.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

/*
 * Main class of the example mod, this class is what forge looks at to load the mod and all of its classes
 * 
 * Note: In 1.11+ lowercasing is enforced, so all items, blocks, and resources must be all lower case (i.e. gui_opener instead of guiOpener)
 */
@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)
public class ExampleMod {
	
	@Instance(Reference.MODID)
	public static ExampleMod instance;
	
	@SidedProxy(serverSide = Reference.SERVER, clientSide = Reference.CLIENT)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(Reference.NAME + " is loading!");
		
		ModItems.init();
		ModBlocks.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
