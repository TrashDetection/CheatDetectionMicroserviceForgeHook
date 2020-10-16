package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttribute;

@Mixin(net.minecraft.entity.ai.attributes.IAttribute.class)
public interface IAttributeMixin extends IAttribute
{

}
