package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IPlayerAbilitiesOutgoingPacket;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;

@Mixin(S39PacketPlayerAbilities.class)
public abstract class S39PacketPlayerAbilitiesMixin implements IPlayerAbilitiesOutgoingPacket
{
	@Shadow private boolean invulnerable;
    @Shadow private boolean flying;
    @Shadow private boolean allowFlying;
    @Shadow private boolean creativeMode;
    
    @Shadow private float flySpeed;
    @Shadow private float walkSpeed;

	@Override
	public boolean isInvulnerable()
	{
		return this.invulnerable;
	}
	
	@Override
	public boolean isFlying()
	{
		return this.flying;
	}

	@Override
	public boolean isFlyingAllowed()
	{
		return this.allowFlying;
	}

	@Override
	public boolean isCreativeMode()
	{
		return this.creativeMode;
	}

	@Override
	public float getFlySpeed()
	{
		return this.flySpeed;
	}
	
	@Override
	public float getWalkSpeed()
	{
		return this.walkSpeed;
	}
}
