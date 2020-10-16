package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.Collection;
import java.util.List;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityPropertiesOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IEntityPropertySnapshot;
import net.minecraft.network.play.server.S20PacketEntityProperties;

@Mixin(S20PacketEntityProperties.class)
public abstract class S20PacketEntityPropertiesMixin implements IEntityPropertiesOutgoingPacket
{
    @Shadow private int entityId;
    @Shadow @Final private List<S20PacketEntityProperties.Snapshot> field_149444_b;
    
	@Override
	public int getEntityId()
	{
		return this.entityId;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<IEntityPropertySnapshot> getProperties()
	{
		return (Collection<IEntityPropertySnapshot>)(Object)this.field_149444_b;
	}
}
