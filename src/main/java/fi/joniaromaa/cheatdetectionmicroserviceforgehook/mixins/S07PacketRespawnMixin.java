package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IRespawnOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IGamemode;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.world.WorldSettings;

@Mixin(S07PacketRespawn.class)
public abstract class S07PacketRespawnMixin implements IRespawnOutgoingPacket
{
    @Shadow private WorldSettings.GameType gameType;
    
	@Override
	public IGamemode getGamemode()
	{
		return (IGamemode)(Object)this.gameType;
	}
}
