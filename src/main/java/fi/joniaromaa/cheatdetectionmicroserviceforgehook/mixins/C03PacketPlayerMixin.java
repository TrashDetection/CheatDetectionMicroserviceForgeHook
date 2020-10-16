package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IPlayerIncomingPacket;
import net.minecraft.network.play.client.C03PacketPlayer;

@Mixin(C03PacketPlayer.class)
public abstract class C03PacketPlayerMixin implements IPlayerIncomingPacket
{
    @Shadow protected double x;
    @Shadow protected double y;
    @Shadow protected double z;
    @Shadow protected float yaw;
    @Shadow protected float pitch;
    @Shadow protected boolean onGround;
    @Shadow protected boolean moving;
    @Shadow protected boolean rotating;
	
	@Override
	public double getX()
	{
		return this.x;
	}
	
	@Override
	public double getY()
	{
		return this.y;
	}
	
	@Override
	public double getZ()
	{
		return this.z;
	}
	
	@Override
	public float getYaw()
	{
		return this.yaw;
	}
    
	@Override
	public float getPitch()
	{
		return this.pitch;
	}

	@Override
	public boolean isOnGround()
	{
		return this.onGround;
	}
	
	@Override
	public boolean isMoving()
	{
		return this.moving;
	}
	
	@Override
	public boolean isRotating()
	{
		return this.rotating;
	}
}
