package fi.joniaromaa.cheatdetectionmicroserviceforgehook.game.world;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.world.IWorldHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IGamemode;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IGamemode.Type;
import net.minecraft.world.WorldSettings;

public class WorldHook implements IWorldHook
{
	@Override
	public IGamemode getGamemode(Type type)
	{
		switch(type)
		{
			case SURVIVAL:
				return (IGamemode)(Object)WorldSettings.GameType.SURVIVAL;
			case CREATIVE:
				return (IGamemode)(Object)WorldSettings.GameType.CREATIVE;
			case ADVENTURE:
				return (IGamemode)(Object)WorldSettings.GameType.ADVENTURE;
			case SPECTATOR:
				return (IGamemode)(Object)WorldSettings.GameType.SPECTATOR;
			default:
				throw new IllegalArgumentException(type.toString());
		}
	}
}
