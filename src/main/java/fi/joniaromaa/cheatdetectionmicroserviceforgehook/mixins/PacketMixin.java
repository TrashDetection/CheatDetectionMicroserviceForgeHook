package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.io.IOException;

import org.spongepowered.asm.mixin.Mixin;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IPacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

@Mixin(Packet.class)
public interface PacketMixin<T extends INetHandler> extends Packet<T>, IMinecraftPacket
{
    public default void readPacket(IPacketBuffer buffer) throws IOException
    {
    	PacketBuffer mcBuffer = (PacketBuffer)buffer;
    	
    	this.readPacketData(mcBuffer);
    }
}
