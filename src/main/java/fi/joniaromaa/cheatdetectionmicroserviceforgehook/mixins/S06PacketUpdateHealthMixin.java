package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IUpdateHealthOutgoingPacket;
import net.minecraft.network.play.server.S06PacketUpdateHealth;

@Mixin(S06PacketUpdateHealth.class)
public abstract class S06PacketUpdateHealthMixin implements IUpdateHealthOutgoingPacket
{
    @Shadow private int foodLevel;
    
	@Override
	public int getFood()
	{
		return this.foodLevel;
	}
}
