package gamedev.example.block;

import gamedev.example.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockBase extends Block {
	
	protected String name;
	
	public BlockBase(Material material, String name) {
		super(material);
		
		this.name = name;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
	}
	
	/*@Override
	public void registerItemModel(Item item) {
		DiceMod.proxy.registerItemRenderer(item, 0, name);
	}*/
	
	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}
