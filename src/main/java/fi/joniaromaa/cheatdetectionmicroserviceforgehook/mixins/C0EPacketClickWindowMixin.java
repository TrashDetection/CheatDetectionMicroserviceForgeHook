package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.item.IItemStack;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IClickWindowIncomingPacket;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C0EPacketClickWindow;

@Mixin(C0EPacketClickWindow.class)
public abstract class C0EPacketClickWindowMixin implements IClickWindowIncomingPacket
{
	private static final IClickWindowIncomingPacket.Mode[] MODES = new IClickWindowIncomingPacket.Mode[]
	{
		IClickWindowIncomingPacket.Mode.CLICK,
		IClickWindowIncomingPacket.Mode.SHIFT_CLICK,
		IClickWindowIncomingPacket.Mode.HOTBAR,
		IClickWindowIncomingPacket.Mode.DROP,
		IClickWindowIncomingPacket.Mode.DRAG,
		IClickWindowIncomingPacket.Mode.DOUBLE_CLICK
	};
	
    @Shadow private int windowId;
    @Shadow private int slotId;
    @Shadow private int usedButton;
    @Shadow private short actionNumber;
    @Shadow private ItemStack clickedItem;
    @Shadow private int mode;

	@Override
	public byte getWindowId()
	{
		return (byte)this.windowId;
	}

	@Override
	public short getSlot()
	{
		return (short)this.slotId;
	}

	@Override
	public Mode getMode()
	{
		if (this.mode >= C0EPacketClickWindowMixin.MODES.length)
		{
			return null;
		}
		
		return C0EPacketClickWindowMixin.MODES[this.mode];
	}

	@Override
	public byte getButton()
	{
		return (byte)this.usedButton;
	}
	
	@Override
	public short getActionNumber()
	{
		return this.actionNumber;
	}
	
	@Override
	public IItemStack getItem()
	{
		return (IItemStack)(Object)this.clickedItem;
	}
}
