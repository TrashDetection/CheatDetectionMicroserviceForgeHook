package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.ICameraOutgoingPacket;
import net.minecraft.network.play.server.S43PacketCamera;

@Mixin(S43PacketCamera.class)
public abstract class S43PacketCameraMixin implements ICameraOutgoingPacket
{
    @Shadow public int entityId;
    
	@Override
	public int getEntityId()
	{
		return this.entityId;
	}
}
