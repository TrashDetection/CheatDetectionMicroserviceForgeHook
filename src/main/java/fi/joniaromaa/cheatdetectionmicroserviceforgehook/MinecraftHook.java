package fi.joniaromaa.cheatdetectionmicroserviceforgehook;

import fi.joniaromaa.cheatdetectionmicroserviceforgehook.game.GameHook;
import fi.joniaromaa.cheatdetectionmicroserviceforgehook.network.NetworkHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.IMinecraftHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.IGameHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.INetworkHook;
import net.minecraft.realms.RealmsSharedConstants;

public class MinecraftHook implements IMinecraftHook
{
	private NetworkHook network;
	private GameHook game;
	
	private MinecraftHook()
	{
		this.network = new NetworkHook();
		this.game = new GameHook();
	}
	
	@Override
	public int getProtocolVersion() 
	{
		return RealmsSharedConstants.NETWORK_PROTOCOL_VERSION;
	}

	@Override
	public String getVersion()
	{
		return RealmsSharedConstants.VERSION_STRING;
	}

	@Override
	public INetworkHook getNetworkHook()
	{
		return this.network;
	}

	@Override
	public IGameHook getGameHook()
	{
		return this.game;
	}

	public static IMinecraftHook build()
	{
		return new MinecraftHook();
	}
}
