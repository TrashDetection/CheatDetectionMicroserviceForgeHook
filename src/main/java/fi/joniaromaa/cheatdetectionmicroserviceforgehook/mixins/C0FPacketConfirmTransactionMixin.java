package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IConfirmTransactionIncomingPacket;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;

@Mixin(C0FPacketConfirmTransaction.class)
public abstract class C0FPacketConfirmTransactionMixin implements IConfirmTransactionIncomingPacket
{
    @Shadow private int windowId;
    @Shadow private short uid;

	@Override
	public byte getWindowId()
	{
		return (byte)this.windowId;
	}

	@Override
	public short getActionNumber()
	{
		return this.uid;
	}
}
