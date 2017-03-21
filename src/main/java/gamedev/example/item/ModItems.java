package gamedev.example.item;

import net.minecraft.item.Item;
import gamedev.example.item.ItemBase;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static ItemDie die6i;
	public static ItemDie die20i;
	public static ExampleGuiOpener guiOpener;
	
	public static void init() {
		die6i = register(new ItemDie("die6i", 6));
		die20i = register(new ItemDie("die20i", 20));
		guiOpener = register(new ExampleGuiOpener("gui_opener"));
	}
	
	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);
		
		if (item instanceof ItemBase) {
			((ItemBase)item).registerItemModel();
		}
		
		return item;
	}

}
