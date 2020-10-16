package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.io.IOException;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IBulkChunkOutgoingPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.network.play.server.S26PacketMapChunkBulk;

@Mixin(S26PacketMapChunkBulk.class)
public abstract class S26PacketMapChunkBulkMixin implements IBulkChunkOutgoingPacket
{
    @Shadow private int[] xPositions;
    @Shadow private int[] zPositions;
    @Shadow private S21PacketChunkData.Extracted[] chunksData;

	@Override
	public int getChunkX(int i)
	{
		return this.xPositions[i];
	}

	@Override
	public int getChunkZ(int i)
	{
		return this.zPositions[i];
	}

	@Override
	public int getCount()
	{
		return this.xPositions.length;
	}

	@Override
	public int[] getXPositions()
	{
		return this.xPositions;
	}

	@Override
	public int[] getZPositions()
	{
		return this.zPositions;
	}
	
    /**
     * @author Joni
     * @reason Temp, we don't send the whole chunk, we also use var ints
     */
    @Overwrite
    public void readPacketData(PacketBuffer buf) throws IOException
    {
		int count = buf.readVarIntFromBuffer();
		
		this.xPositions = new int[count];
		this.zPositions = new int[count];
		
		this.chunksData = new S21PacketChunkData.Extracted[count];
		
		for(int i = 0; i < count; i++)
		{
			this.xPositions[i] = buf.readVarIntFromBuffer();
			this.zPositions[i] = buf.readVarIntFromBuffer();
			
			S21PacketChunkData.Extracted extracted = new S21PacketChunkData.Extracted();
			extracted.dataSize =  buf.readVarIntFromBuffer();
			
			this.chunksData[i] = extracted;
		}
    }
}
