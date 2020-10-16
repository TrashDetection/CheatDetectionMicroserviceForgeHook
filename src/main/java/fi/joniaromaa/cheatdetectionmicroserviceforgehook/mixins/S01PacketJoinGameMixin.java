package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IJoinOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IGamemode;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.world.WorldSettings;

@Mixin(S01PacketJoinGame.class)
public abstract class S01PacketJoinGameMixin implements IJoinOutgoingPacket
{
    @Shadow private int entityId;
    @Shadow private WorldSettings.GameType gameType;
    
	@Override
	public int getEntityId()
	{
		return this.entityId;
	}
	
	@Override
	public IGamemode getGamemode()
	{
		return (IGamemode)(Object)this.gameType;
	}
}
