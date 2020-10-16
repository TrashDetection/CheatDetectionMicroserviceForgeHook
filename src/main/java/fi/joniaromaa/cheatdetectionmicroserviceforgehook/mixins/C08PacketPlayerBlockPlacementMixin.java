package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.item.IItemStack;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IBlockPlaceIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IBlockPos;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

@Mixin(C08PacketPlayerBlockPlacement.class)
public abstract class C08PacketPlayerBlockPlacementMixin implements IBlockPlaceIncomingPacket
{
    @Shadow private BlockPos position;
    @Shadow private int placedBlockDirection;
    @Shadow private ItemStack stack;
    @Shadow private float facingX;
    @Shadow private float facingY;
    @Shadow private float facingZ;

	@Override
	public IBlockPos getPosition()
	{
		return (IBlockPos)this.position;
	}
	
	@Override
	public IFacing getFacing()
	{
		if (this.isInteract())
		{
			throw new IllegalStateException();
		}
		
		return (IFacing)(Object)EnumFacing.getFront(this.placedBlockDirection);
	}

	@Override
	public IItemStack getItem()
	{
		return (IItemStack)(Object)this.stack;
	}

	@Override
	public float getFacingX() 
	{
		return this.facingX;
	}

	@Override
	public float getFacingY()
	{
		return this.facingY;
	}

	@Override
	public float getFacingZ()
	{
		return this.facingZ;
	}
	
	@Override
	public boolean isInteract()
	{
		return this.placedBlockDirection == 255;
	}
}
