package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityTeleportOutgoingPacket;
import net.minecraft.network.play.server.S18PacketEntityTeleport;

@Mixin(S18PacketEntityTeleport.class)
public abstract class S18PacketEntityTeleportMixin implements IEntityTeleportOutgoingPacket
{
    @Shadow private int entityId;
    @Shadow private int posX;
    @Shadow private int posY;
    @Shadow private int posZ;
    @Shadow private byte yaw;
    @Shadow private byte pitch;
    @Shadow private boolean onGround;
    
	@Override
	public int getEntityId()
	{
		return this.entityId;
	}

	@Override
	public int getServerX()
	{
		return this.posX;
	}

	@Override
	public int getServerY()
	{
		return this.posY;
	}

	@Override
	public int getServerZ()
	{
		return this.posZ;
	}

	@Override
	public double getX()
	{
		return (double)this.getServerX() / 32.0D;
	}

	@Override
	public double getY()
	{
		return (double)this.getServerY() / 32.0D;
	}

	@Override
	public double getZ()
	{
		return (double)this.getServerZ() / 32.0D;
	}
}
