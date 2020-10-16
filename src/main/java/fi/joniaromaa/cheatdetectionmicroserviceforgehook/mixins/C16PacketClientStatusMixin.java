package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.IdentityHashMap;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IClientStatusIncomingPacket;
import net.minecraft.network.play.client.C16PacketClientStatus;

@Mixin(C16PacketClientStatus.class)
public abstract class C16PacketClientStatusMixin implements IClientStatusIncomingPacket
{
	private static final IdentityHashMap<C16PacketClientStatus.EnumState, IClientStatusIncomingPacket.Status> MAPPED = new IdentityHashMap<>();
	
	static
	{
		C16PacketClientStatusMixin.MAPPED.put(C16PacketClientStatus.EnumState.PERFORM_RESPAWN, IClientStatusIncomingPacket.Status.PERFORM_RESPAWN);
		C16PacketClientStatusMixin.MAPPED.put(C16PacketClientStatus.EnumState.REQUEST_STATS, IClientStatusIncomingPacket.Status.REQUEST_STATS);
		C16PacketClientStatusMixin.MAPPED.put(C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT, IClientStatusIncomingPacket.Status.OPEN_INVENTORY_ACHIEVEMENT);
	}

    @Shadow private C16PacketClientStatus.EnumState status;
    
	@Override
	public Status getStatus()
	{
		return C16PacketClientStatusMixin.MAPPED.get(this.status);
	}
}
