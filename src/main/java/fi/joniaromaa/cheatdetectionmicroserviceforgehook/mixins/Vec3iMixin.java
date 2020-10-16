package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IPos;
import net.minecraft.util.Vec3i;

@Mixin(Vec3i.class)
public abstract class Vec3iMixin implements IPos
{
    @Shadow @Final private int x;
    @Shadow @Final private int y;
    @Shadow @Final private int z;
    
	@Override
	public int getX()
	{
		return this.x;
	}

	@Override
	public int getY()
	{
		return this.y;
	}

	@Override
	public int getZ()
	{
		return this.z;
	}
}
