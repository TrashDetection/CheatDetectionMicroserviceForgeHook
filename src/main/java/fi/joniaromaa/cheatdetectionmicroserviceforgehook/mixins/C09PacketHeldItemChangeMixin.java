package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IHeldItemChangeIncomingPacket;
import net.minecraft.network.play.client.C09PacketHeldItemChange;

@Mixin(C09PacketHeldItemChange.class)
public abstract class C09PacketHeldItemChangeMixin implements IHeldItemChangeIncomingPacket
{
    @Shadow private int slotId;
    
    @Override
    public short getSlot()
    {
    	return (short)this.slotId;
    }
}
