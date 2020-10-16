package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IVectorPos;
import net.minecraft.util.Vec3;

@Mixin(Vec3.class)
public abstract class Vec3Mixin implements IVectorPos
{
    @Shadow @Final public double xCoord;
    @Shadow @Final public double yCoord;
    @Shadow @Final public double zCoord;
    
	@Override
	public double getX()
	{
		return this.xCoord;
	}

	@Override
	public double getY()
	{
		return this.yCoord;
	}

	@Override
	public double getZ()
	{
		return this.zCoord;
	}

}	
