package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IKeepAliveOutgoingPacket;
import net.minecraft.network.play.server.S00PacketKeepAlive;

@Mixin(S00PacketKeepAlive.class)
public abstract class S00PacketKeepAliveMixin implements IKeepAliveOutgoingPacket
{
    @Shadow private int id;
    
	@Override
	public boolean isAsync()
	{
		return true;
	}
	
	@Override
	public int getId()
	{
		return this.id;
	}
}
