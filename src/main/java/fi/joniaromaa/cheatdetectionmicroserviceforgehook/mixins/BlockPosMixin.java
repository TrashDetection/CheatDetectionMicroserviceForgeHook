package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IBlockPos;
import net.minecraft.util.BlockPos;

@Mixin(BlockPos.class)
public abstract class BlockPosMixin implements IBlockPos
{
}
