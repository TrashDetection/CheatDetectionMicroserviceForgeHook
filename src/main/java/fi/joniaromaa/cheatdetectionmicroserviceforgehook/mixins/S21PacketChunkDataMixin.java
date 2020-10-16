package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.io.IOException;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IChunkOutgoingPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S21PacketChunkData;

@Mixin(S21PacketChunkData.class)
public abstract class S21PacketChunkDataMixin implements IChunkOutgoingPacket
{
    @Shadow private int chunkX;
    @Shadow private int chunkZ;
    @Shadow private S21PacketChunkData.Extracted extractedData;
    @Shadow private boolean field_149279_g;
    
	@Override
	public int getChunkX()
	{
		return this.chunkX;
	}

	@Override
	public int getChunkZ()
	{
		return this.chunkZ;
	}

	@Override
	public int getExtractedDataLength()
	{
		return this.extractedData.dataSize;
	}

	@Override
	public boolean isFullChunk()
	{
		return this.field_149279_g;
	}
	
    /**
     * @author Joni
     * @reason Temp, we don't send the whole chunk, we also use var ints
     */
    @Overwrite
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.chunkX = buf.readVarIntFromBuffer();
        this.chunkZ = buf.readVarIntFromBuffer();
        this.field_149279_g = buf.readBoolean();
        
		S21PacketChunkData.Extracted extracted = new S21PacketChunkData.Extracted();
		extracted.dataSize = buf.readVarIntFromBuffer();
		
		this.extractedData = extracted;
    }
}
