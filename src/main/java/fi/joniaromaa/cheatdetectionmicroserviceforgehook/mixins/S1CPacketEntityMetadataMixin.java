package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.Collection;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEnittyMetadataOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IWatchableObject;
import net.minecraft.entity.DataWatcher;
import net.minecraft.network.play.server.S1CPacketEntityMetadata;

@Mixin(S1CPacketEntityMetadata.class)
public abstract class S1CPacketEntityMetadataMixin implements IEnittyMetadataOutgoingPacket
{
    @Shadow private int entityId;
    @Shadow private List<DataWatcher.WatchableObject> field_149378_b;
    
	@Override
	public int getEntityId()
	{
		return this.entityId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<IWatchableObject> getWatchedObjects()
	{
		return (Collection<IWatchableObject>)(Object)this.field_149378_b;
	}
}
