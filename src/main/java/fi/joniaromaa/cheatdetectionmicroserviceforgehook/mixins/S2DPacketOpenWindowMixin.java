package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IOpenWindowOutgoingPacket;
import net.minecraft.network.play.server.S2DPacketOpenWindow;

@Mixin(S2DPacketOpenWindow.class)
public abstract class S2DPacketOpenWindowMixin implements IOpenWindowOutgoingPacket
{
    @Shadow private int windowId;
    
	@Override
	public int getWindowId()
	{
		return this.windowId;
	}
}
