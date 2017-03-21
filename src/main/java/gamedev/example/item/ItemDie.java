package gamedev.example.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemDie extends ItemBase {
	private int max;
	
	public ItemDie (String name, int max) {
		super(name);
		this.setMaxStackSize(1);
		this.max = max;
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.sendMessage(new TextComponentString("Roll: " + (int)Math.ceil(Math.random() * max)));
        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }

}
