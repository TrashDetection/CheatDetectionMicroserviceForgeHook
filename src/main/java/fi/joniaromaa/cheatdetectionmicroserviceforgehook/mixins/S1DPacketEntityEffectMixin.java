package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityEffectOutgoingPacket;
import net.minecraft.network.play.server.S1DPacketEntityEffect;

@Mixin(S1DPacketEntityEffect.class)
public abstract class S1DPacketEntityEffectMixin implements IEntityEffectOutgoingPacket
{
    @Shadow private int entityId;
    
    @Shadow private byte effectId;
    @Shadow private byte amplifier;
    
    @Shadow private int duration;

	@Override
	public int getEntityId()
	{
		return this.entityId;
	}
	
	@Override
	public byte getEffectId()
	{
		return this.effectId;
	}
    
	@Override
	public byte getAmplifier()
	{
		return this.amplifier;
	}

	@Override
	public int getDuration()
	{
		return this.duration;
	}
}
