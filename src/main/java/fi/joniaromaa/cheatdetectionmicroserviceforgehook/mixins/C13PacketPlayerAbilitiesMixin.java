package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IPlayerAbilitiesIncomingPacket;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;

@Mixin(C13PacketPlayerAbilities.class)
public abstract class C13PacketPlayerAbilitiesMixin implements IPlayerAbilitiesIncomingPacket
{
    @Shadow private boolean flying;
    @Shadow private boolean allowFlying;
    @Shadow private float flySpeed;
    @Shadow private float walkSpeed;

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
