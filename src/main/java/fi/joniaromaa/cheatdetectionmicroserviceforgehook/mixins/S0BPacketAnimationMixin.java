package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IAnimationOutgoingPacket;
import net.minecraft.network.play.server.S0BPacketAnimation;

@Mixin(S0BPacketAnimation.class)
public abstract class S0BPacketAnimationMixin implements IAnimationOutgoingPacket
{
    @Shadow private int entityId;
    @Shadow private int type;
    
    private static final Animation[] ANIMATIONS = new Animation[]
	{
		Animation.SWING,
		Animation.HURT,
		Animation.WAKE_UP,
		Animation.CONSUME,
		Animation.CRITICAL,
		Animation.MAGIC_CRITICAL
	};

	@Override
	public int getEntityId()
	{
		return this.entityId;
	}

	@Override
	public Animation getAnimation()
	{
		if (this.type >= ANIMATIONS.length)
		{
			return null;
		}
		
		return S0BPacketAnimationMixin.ANIMATIONS[this.type];
	}
}
