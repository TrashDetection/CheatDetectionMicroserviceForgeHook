package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeInstance;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeModifier;

@Mixin(net.minecraft.entity.ai.attributes.IAttributeInstance.class)
@Implements(@Interface(iface = IAttributeInstance.class, prefix = "attr$"))
public interface IAttributeInstanceMixin
{
	@Shadow void shadow$setBaseValue(double baseValue);
	@Shadow void shadow$removeAllModifiers();
	@Shadow boolean shadow$hasModifier(net.minecraft.entity.ai.attributes.AttributeModifier modifier);
	@Shadow void shadow$removeModifier(net.minecraft.entity.ai.attributes.AttributeModifier modifier);
	@Shadow void shadow$applyModifier(net.minecraft.entity.ai.attributes.AttributeModifier modifier);
	@Shadow double shadow$getAttributeValue();
	
    @Intrinsic
	public default void attr$setBaseValue(double value)
	{
		this.shadow$setBaseValue(value);
	}

    @Intrinsic
	public default void attr$removeAllModifiers()
	{
		this.shadow$removeAllModifiers();
	}

    @Intrinsic
	public default boolean attr$hasModifier(IAttributeModifier modifier)
	{
		return this.shadow$hasModifier((net.minecraft.entity.ai.attributes.AttributeModifier)modifier);
	}

    @Intrinsic
    public default void attr$removeModifier(IAttributeModifier modifier)
    {
    	this.shadow$removeModifier((net.minecraft.entity.ai.attributes.AttributeModifier)modifier);
    }

    @Intrinsic
	public default void attr$applyModifier(IAttributeModifier modifier)
	{
		this.shadow$applyModifier((net.minecraft.entity.ai.attributes.AttributeModifier)modifier);
	}

    @Intrinsic
    public default double attr$getAttributeValue()
    {
		return this.shadow$getAttributeValue();
    }
}
