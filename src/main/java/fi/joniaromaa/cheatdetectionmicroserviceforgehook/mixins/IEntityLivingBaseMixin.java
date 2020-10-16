package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;

@Mixin(EntityLivingBase.class)
public interface IEntityLivingBaseMixin
{
    @Accessor
    public static AttributeModifier getSprintingSpeedBoostModifier()
    {
        throw new NotImplementedException("IEntityLivingBaseMixin mixin failed to apply");
    }
}
