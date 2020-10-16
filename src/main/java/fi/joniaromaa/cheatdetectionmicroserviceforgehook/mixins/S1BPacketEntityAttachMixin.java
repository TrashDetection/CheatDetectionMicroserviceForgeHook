package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityAttachOutgoingPacket;
import net.minecraft.network.play.server.S1BPacketEntityAttach;

@Mixin(S1BPacketEntityAttach.class)
public abstract class S1BPacketEntityAttachMixin implements IEntityAttachOutgoingPacket
{
    @Shadow private int leash;
    @Shadow private int entityId;
    @Shadow private int vehicleEntityId;

	@Override
	public int getEntityId()
	{
		return this.entityId;
	}
	
	@Override
	public int getVehicleId()
	{
		return this.vehicleEntityId;
	}
	
	@Override
	public boolean isLeashed()
	{
		return this.leash != 0;
	}
}
