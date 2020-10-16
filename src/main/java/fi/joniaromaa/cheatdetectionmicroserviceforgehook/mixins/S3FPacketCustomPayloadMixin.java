package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IPacketBuffer;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IPluginMessageOutgoingPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S3FPacketCustomPayload;

@Mixin(S3FPacketCustomPayload.class)
public abstract class S3FPacketCustomPayloadMixin implements IPluginMessageOutgoingPacket
{
    @Shadow private String channel;
    @Shadow private PacketBuffer data;
    
    private Object cachedObject;
    
    @Override
	public String getChannel()
	{
		return this.channel;
	}

    @Override
	public IPacketBuffer getData()
	{
		return (IPacketBuffer)this.data;
	}

    @Override
	public Object getDataObject()
	{
		if (this.cachedObject == null)
		{
			this.cachedObject = IPluginMessageOutgoingPacket.buildDataObject(this.channel, this.getData());
		}
		
		return this.cachedObject;
	}
}
