package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IPlayerPositionAndLookOutgoingPacket;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;

@Mixin(S08PacketPlayerPosLook.class)
public abstract class S08PacketPlayerPosLookMixin implements IPlayerPositionAndLookOutgoingPacket
{
    @Shadow protected double x;
    @Shadow protected double y;
    @Shadow protected double z;
    @Shadow protected float yaw;
    @Shadow protected float pitch;
	
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
}
