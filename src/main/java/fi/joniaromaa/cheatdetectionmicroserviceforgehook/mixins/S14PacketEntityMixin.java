package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityOutgoingPacket;
import net.minecraft.network.play.server.S14PacketEntity;

@Mixin(S14PacketEntity.class)
public abstract class S14PacketEntityMixin implements IEntityOutgoingPacket
{
    @Shadow protected int entityId;
    @Shadow protected byte posX;
    @Shadow protected byte posY;
    @Shadow protected byte posZ;
    @Shadow protected byte yaw;
    @Shadow protected byte pitch;
    @Shadow protected boolean onGround;
    @Shadow protected boolean field_149069_g;
    
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
}
