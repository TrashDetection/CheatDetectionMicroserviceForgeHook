package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IDestroyEntitiesOutgoingPacket;
import net.minecraft.network.play.server.S13PacketDestroyEntities;

@Mixin(S13PacketDestroyEntities.class)
public abstract class S13PacketDestroyEntitiesMixin implements IDestroyEntitiesOutgoingPacket
{
    @Shadow private int[] entityIDs;
    
    @Override
	public Collection<Integer> getEntityIds()
	{
		return Collections.unmodifiableCollection(Arrays.stream(this.entityIDs).boxed().collect(Collectors.toList()));
	}
}
