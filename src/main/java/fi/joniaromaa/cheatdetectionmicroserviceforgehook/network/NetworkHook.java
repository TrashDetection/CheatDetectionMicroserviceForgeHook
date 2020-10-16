package fi.joniaromaa.cheatdetectionmicroserviceforgehook.network;

import java.util.Map;

import fi.joniaromaa.cheatdetectionmicroserviceforgehook.ducks.IEnumConnectionStateMixin;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.INetworkHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IPacketBuffer;
import io.netty.buffer.Unpooled;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.PacketBuffer;

public class NetworkHook implements INetworkHook
{
	@Override
	public IPacketBuffer createEmptyBuffer()
	{
		PacketBuffer buffer = new PacketBuffer(Unpooled.EMPTY_BUFFER);
		
		return (IPacketBuffer)buffer;
	}
	
	@Override
	public Map<Integer, Class<? extends IMinecraftPacket>> getIncomingPlayPackets()
	{
		return ((IEnumConnectionStateMixin)EnumConnectionState.PLAY).getIncomings();
	}

	@Override
	public Map<Integer, Class<? extends IMinecraftPacket>> getOutgoingPlayPackets()
	{
		return ((IEnumConnectionStateMixin)EnumConnectionState.PLAY).getOutgoings();
	}
}
