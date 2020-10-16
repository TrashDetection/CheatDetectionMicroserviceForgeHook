package fi.joniaromaa.cheatdetectionmicroserviceforgehook.game;

import fi.joniaromaa.cheatdetectionmicroserviceforgehook.game.entity.EntityHook;
import fi.joniaromaa.cheatdetectionmicroserviceforgehook.game.world.WorldHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.IGameHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.IEntityHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.world.IWorldHook;

public class GameHook implements IGameHook
{
	private final EntityHook entity;
	private final WorldHook world;
	
	public GameHook()
	{
		this.entity = new EntityHook();
		this.world = new WorldHook();
	}

	@Override
	public IEntityHook getEntityHook()
	{
		return this.entity;
	}
	
	@Override
	public IWorldHook getWorldHook()
	{
		return this.world;
	}
}
