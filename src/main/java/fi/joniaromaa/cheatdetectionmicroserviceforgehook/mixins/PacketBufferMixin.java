package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IPacketBuffer;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;

@Mixin(PacketBuffer.class)
public abstract class PacketBufferMixin implements IPacketBuffer
{
	@Shadow @Final @Mutable private ByteBuf buf;
	
	@Shadow public abstract int readVarIntFromBuffer();
	@Shadow public abstract String readStringFromBuffer(int maxLength);

	@Override
	public byte readByte()
	{
		return this.buf.readByte();
	}
	
	@Override
	public boolean readBoolean()
	{
		return this.buf.readBoolean();
	}

	@Override
	public String readString(int maxLength)
	{
		return this.readStringFromBuffer(maxLength);
	}
	
	@Override
	public int readVarInt()
	{
		return this.readVarIntFromBuffer();
	}
	
	@Override
	public int readInt()
	{
		return this.buf.readInt();
	}
	
	@Override
	public float readFloat()
	{
		return this.buf.readFloat();
	}

	@Override
	public double readDouble()
	{
		return this.buf.readDouble();
	}
	
	@Override
	public ByteBuf getBuffer()
	{
		return this.buf;
	}

	@Override
	public void setBuffer(ByteBuf buffer)
	{
		this.buf = buffer;
	}
}
