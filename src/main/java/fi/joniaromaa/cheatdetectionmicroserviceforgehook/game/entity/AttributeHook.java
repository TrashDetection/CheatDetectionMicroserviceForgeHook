package fi.joniaromaa.cheatdetectionmicroserviceforgehook.game.entity;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttribute;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeMap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.ServersideAttributeMap;

public class AttributeHook implements IAttributeHook
{
	@Override
	public IAttributeMap createAttributeMap()
	{
		return (IAttributeMap)new ServersideAttributeMap();
	}

	@Override
	public IAttribute getSharedMovementSpeedAttribute()
	{
		return (IAttribute)SharedMonsterAttributes.movementSpeed;
	}
}
