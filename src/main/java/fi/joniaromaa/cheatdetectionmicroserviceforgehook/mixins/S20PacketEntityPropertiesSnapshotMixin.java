package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.Collection;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeModifier;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IEntityPropertySnapshot;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.play.server.S20PacketEntityProperties;

@Mixin(S20PacketEntityProperties.Snapshot.class)
public abstract class S20PacketEntityPropertiesSnapshotMixin implements IEntityPropertySnapshot
{
    @Shadow @Final private String field_151412_b;
    @Shadow @Final private double field_151413_c;
    @Shadow @Final private Collection<AttributeModifier> field_151411_d;
    
    @Override
	public String getName()
	{
		return this.field_151412_b;
	}
    
    @Override
	public double getInitialValue()
	{
		return this.field_151413_c;
	}

    @SuppressWarnings("unchecked")
	@Override
	public Collection<IAttributeModifier> getModifiers()
	{
		return (Collection<IAttributeModifier>)(Object)this.field_151411_d;
	}
}
