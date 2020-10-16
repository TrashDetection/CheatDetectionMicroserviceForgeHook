package fi.joniaromaa.cheatdetectionmicroserviceforgehook.game.entity;

import java.util.UUID;

import fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins.IEntityLivingBaseMixin;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.IEntityHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeModifier;

public class EntityHook implements IEntityHook
{
	private final AttributeHook attribute;
	
	public EntityHook()
	{
		this.attribute = new AttributeHook();
	}
	
	@Override
	public IAttributeHook getAttributeHook()
	{
		return this.attribute;
	}
	
	@Override
	public IAttributeModifier getSprintingSpeedBoostModifier()
	{
		return (IAttributeModifier)IEntityLivingBaseMixin.getSprintingSpeedBoostModifier();
	}
}
