package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.UUID;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier;

@Mixin(AttributeModifier.class)
public abstract class AttributeModifierMixin implements IAttributeModifier
{
	private static final IAttributeModifier.Modifier[] MODIFIERS = new IAttributeModifier.Modifier[]
	{
		IAttributeModifier.Modifier.ADDITIVE,
		IAttributeModifier.Modifier.MULTIPLICATIVE_ADDITIVE,
		IAttributeModifier.Modifier.MULTIPLICATIVE_CURRENT,
	};
	
    @Shadow @Final private double amount;
    @Shadow @Final private int operation;
    @Shadow @Final private UUID id;
    
    @Override
	public UUID getUniqueId()
	{
		return this.id;
	}

    @Override
	public double getAmount()
	{
		return this.amount;
	}

    @Override
	public IAttributeModifier.Modifier getModifier()
	{
		return AttributeModifierMixin.MODIFIERS[this.operation];
	}
}
