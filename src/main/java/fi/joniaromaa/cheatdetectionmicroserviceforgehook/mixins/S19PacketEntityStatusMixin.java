package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityStatusOutgoingPacket;
import net.minecraft.network.play.server.S19PacketEntityStatus;

@Mixin(S19PacketEntityStatus.class)
public abstract class S19PacketEntityStatusMixin implements IEntityStatusOutgoingPacket
{
    @Shadow private int entityId;
    @Shadow private byte logicOpcode;
    
	@Override
	public int getEntityId()
	{
		return this.entityId;
	}

	@Override
	public byte getStatus()
	{
		return this.logicOpcode;
	}
}
