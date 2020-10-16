package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IUseBedOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IBlockPos;
import net.minecraft.network.play.server.S0APacketUseBed;
import net.minecraft.util.BlockPos;

@Mixin(S0APacketUseBed.class)
public abstract class S0APacketUseBedMixin implements IUseBedOutgoingPacket
{
    @Shadow private int playerID;
    @Shadow private BlockPos bedPos;
    
	@Override
	public int getEntityId()
	{
		return this.playerID;
	}
	
	@Override
	public IBlockPos getPosition()
	{
		return (IBlockPos)this.bedPos;
	}
}
