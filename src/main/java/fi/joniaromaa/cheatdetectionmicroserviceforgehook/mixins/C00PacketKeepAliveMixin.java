package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IKeepAliveIncomingPacket;
import net.minecraft.network.play.client.C00PacketKeepAlive;

@Mixin(C00PacketKeepAlive.class)
public abstract class C00PacketKeepAliveMixin implements IKeepAliveIncomingPacket
{
    @Shadow private int key;
    
	@Override
	public boolean isAsync()
	{
		return true;
	}
	
	@Override
	public int getId()
	{
		return this.key;
	}
}
