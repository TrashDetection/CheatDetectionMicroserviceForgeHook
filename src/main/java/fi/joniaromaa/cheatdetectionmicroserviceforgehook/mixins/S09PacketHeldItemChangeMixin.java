package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IHeldItemChangeOutgoingPacket;
import net.minecraft.network.play.server.S09PacketHeldItemChange;

@Mixin(S09PacketHeldItemChange.class)
public abstract class S09PacketHeldItemChangeMixin implements IHeldItemChangeOutgoingPacket
{
    @Shadow private int heldItemHotbarIndex;
    
	@Override
	public byte getSlot()
	{
		return (byte)this.heldItemHotbarIndex;
	}
}
