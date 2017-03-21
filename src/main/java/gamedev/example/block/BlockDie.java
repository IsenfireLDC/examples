package gamedev.example.block;

import javax.annotation.Nullable;

import gamedev.example.tileentity.TileEntityDie;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockDie extends BlockTileEntity<TileEntityDie> {
	
	private int max;
	
	public BlockDie(String name, int max) {
		super(Material.ROCK, name);
		this.max = max;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntityDie tile = getTileEntity(world, pos);
			player.sendMessage(new TextComponentString("Roll: " + tile.roll()));
		}
		return true;
	}
	
	@Override
	public Class<TileEntityDie> getTileEntityClass() {
		return TileEntityDie.class;
	}
	
	@Nullable
	@Override
	public TileEntityDie createTileEntity(World world, IBlockState state) {
		return new TileEntityDie(max);
	}

}