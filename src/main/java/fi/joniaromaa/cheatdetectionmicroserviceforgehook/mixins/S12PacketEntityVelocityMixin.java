package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityVelocityOutgoingPacket;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

@Mixin(S12PacketEntityVelocity.class)
public abstract class S12PacketEntityVelocityMixin implements IEntityVelocityOutgoingPacket
{
    @Shadow private int entityID;
    @Shadow private int motionX;
    @Shadow private int motionY;
    @Shadow private int motionZ;
    
    @Override
	public int getEntityId()
	{
		return this.entityID;
	}

    @Override
	public short getVelocityX()
    {
    	return (short)this.motionX;
    }
    
    @Override
	public short getVelocityY()
    {
    	return (short)this.motionY;
    }
    
    @Override
	public short getVelocityZ()
    {
    	return (short)this.motionZ;
    }
}
