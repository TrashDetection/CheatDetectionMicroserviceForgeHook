package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttribute;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeInstance;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeMap;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;

@Mixin(BaseAttributeMap.class)
public abstract class BaseAttributeMapMixin implements IAttributeMap
{
	@Shadow public abstract net.minecraft.entity.ai.attributes.IAttributeInstance shadow$registerAttribute(net.minecraft.entity.ai.attributes.IAttribute attribute);

	@Shadow public abstract net.minecraft.entity.ai.attributes.IAttributeInstance shadow$getAttributeInstance(net.minecraft.entity.ai.attributes.IAttribute attribute);
	@Shadow public abstract net.minecraft.entity.ai.attributes.IAttributeInstance shadow$getAttributeInstanceByName(String attributeName);
	
	@Override
	public IAttributeInstance registerAttribute(IAttribute attribute)
	{
		return (IAttributeInstance)this.shadow$registerAttribute((net.minecraft.entity.ai.attributes.IAttribute)attribute);
	}

	@Override
    public IAttributeInstance getAttributeInstance(IAttribute attribute)
    {
    	return (IAttributeInstance)this.shadow$getAttributeInstance((net.minecraft.entity.ai.attributes.IAttribute)attribute);
    }

	@Override
	public IAttributeInstance getAttributeInstanceByName(String name)
	{
		return (IAttributeInstance)this.shadow$getAttributeInstanceByName(name);
	}
}
