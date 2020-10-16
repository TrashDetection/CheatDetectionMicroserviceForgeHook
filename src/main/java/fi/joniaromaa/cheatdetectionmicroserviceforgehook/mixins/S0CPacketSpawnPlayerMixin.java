package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.ISpawnPlayerOutgoingPacket;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;

@Mixin(S0CPacketSpawnPlayer.class)
public abstract class S0CPacketSpawnPlayerMixin implements ISpawnPlayerOutgoingPacket
{
    @Shadow private int entityId;
    @Shadow private int x;
    @Shadow private int y;
    @Shadow private int z;

	@Override
	public int getEntityId()
	{
		return this.entityId;
	}

	@Override
	public int getServerX()
	{
		return this.x;
	}

	@Override
	public int getServerY()
	{
		return this.y;
	}

	@Override
	public int getServerZ()
	{
		return this.z;
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
