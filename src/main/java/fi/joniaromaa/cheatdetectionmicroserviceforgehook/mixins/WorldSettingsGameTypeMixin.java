package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IGamemode;
import net.minecraft.world.WorldSettings;

@Mixin(WorldSettings.GameType.class)
public abstract class WorldSettingsGameTypeMixin implements IGamemode
{
	@Override
	public boolean isSurvivalOrAdventure()
    {
        return (WorldSettings.GameType)(Object)this == WorldSettings.GameType.SURVIVAL || (WorldSettings.GameType)(Object)this == WorldSettings.GameType.ADVENTURE;
    }
	
	@Override
	public boolean isCreative()
	{
		return (WorldSettings.GameType)(Object)this == WorldSettings.GameType.CREATIVE;
	}

	@Override
	public boolean isSpectator()
	{
		return (WorldSettings.GameType)(Object)this == WorldSettings.GameType.SPECTATOR;
	}
}
