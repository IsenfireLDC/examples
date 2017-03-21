package gamedev.example.item;

import gamedev.example.gui.ExampleGui;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ExampleGuiOpener extends ItemBase {
	
	public ExampleGuiOpener(String name) {
		super(name);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		Minecraft.getMinecraft().displayGuiScreen(new ExampleGui());
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
	}

}
