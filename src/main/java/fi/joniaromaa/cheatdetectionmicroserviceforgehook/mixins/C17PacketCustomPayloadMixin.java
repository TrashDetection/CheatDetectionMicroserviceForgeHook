package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IPacketBuffer;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IPluginMessageIncomingPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;

@Mixin(C17PacketCustomPayload.class)
public abstract class C17PacketCustomPayloadMixin implements IPluginMessageIncomingPacket
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
			this.cachedObject = IPluginMessageIncomingPacket.buildDataObject(this.channel, this.getData());
		}
		
		return this.cachedObject;
	}
}
