package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IWatchableObject;
import net.minecraft.entity.DataWatcher;

@Mixin(DataWatcher.WatchableObject.class)
public abstract class DataWatcherWatchableObjectMixin implements IWatchableObject
{
    @Shadow @Final private int dataValueId;
    @Shadow private Object watchedObject;
    
	@Override
	public int getDataValueId()
	{
		return this.dataValueId;
	}
	
	@Override
	public Object getWatchedObject()
	{
		return this.watchedObject;
	}
}
