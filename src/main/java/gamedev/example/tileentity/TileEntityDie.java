package gamedev.example.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDie extends TileEntity {
	
	private int max;
	
	public TileEntityDie (int max) {
		this.max = max;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("max", max);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		max = compound.getInteger("max");
		super.readFromNBT(compound);
	}
	
	/*public void setMax(int max) {
		this.max = max;
	}*/
	
	public int roll() {
		int rolled = (int)Math.ceil(Math.random() * max);
		return rolled;
	}
}
