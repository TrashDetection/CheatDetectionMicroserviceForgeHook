package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IConfirmTransactionOutgoingPacket;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;

@Mixin(S32PacketConfirmTransaction.class)
public abstract class S32PacketConfirmTransactionMixin implements IConfirmTransactionOutgoingPacket
{
    @Shadow private int windowId;
    @Shadow private short actionNumber;
    
	@Override
	public byte getWindowId()
	{
		return (byte)this.windowId;
	}

	@Override
	public short getActionNumber()
	{
		return this.actionNumber;
	}
}
