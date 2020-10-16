package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.item.IItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements IItemStack
{
    @Shadow private Item item;
    @Shadow int itemDamage;
    
	@Override
	public int getItemId()
	{
		return Item.itemRegistry.getIDForObject(this.item);
	}

	@Override
	public int getMetadata()
	{
		return this.itemDamage;
	}
	
	@Override
	public boolean isAir()
	{
		return this.getItemId() == 0;
	}
}
