package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.IdentityHashMap;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IPlayerDiggingIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IFacing;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IPos;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

@Mixin(C07PacketPlayerDigging.class)
public abstract class C07PacketPlayerDiggingMixin implements IPlayerDiggingIncomingPacket
{
	private static final IdentityHashMap<C07PacketPlayerDigging.Action, IPlayerDiggingIncomingPacket.Action> MAPPED = new IdentityHashMap<>();

	static
	{
		C07PacketPlayerDiggingMixin.MAPPED.put(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, IPlayerDiggingIncomingPacket.Action.START_DESTROY_BLOCK);
		C07PacketPlayerDiggingMixin.MAPPED.put(C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, IPlayerDiggingIncomingPacket.Action.ABORT_DESTROY_BLOCK);
		C07PacketPlayerDiggingMixin.MAPPED.put(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, IPlayerDiggingIncomingPacket.Action.STOP_DESTROY_BLOCK);
		C07PacketPlayerDiggingMixin.MAPPED.put(C07PacketPlayerDigging.Action.DROP_ALL_ITEMS, IPlayerDiggingIncomingPacket.Action.DROP_ALL_ITEMS);
		C07PacketPlayerDiggingMixin.MAPPED.put(C07PacketPlayerDigging.Action.DROP_ITEM, IPlayerDiggingIncomingPacket.Action.DROP_ITEM);
		C07PacketPlayerDiggingMixin.MAPPED.put(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, IPlayerDiggingIncomingPacket.Action.RELEASE_USE_ITEM);
	}

	@Shadow private BlockPos position;
    @Shadow private EnumFacing facing;
    @Shadow private C07PacketPlayerDigging.Action status;

	public IPos getPosition()
	{
		return (IPos)this.position;
	}
	
	public IFacing getFacing()
	{
		return (IFacing)(Object)this.facing;
	}
	
    @Override
    public Action getAction()
    {
    	return C07PacketPlayerDiggingMixin.MAPPED.get(this.status);
    }
}
