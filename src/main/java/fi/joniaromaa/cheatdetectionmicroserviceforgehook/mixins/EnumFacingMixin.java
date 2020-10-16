package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IFacing;
import net.minecraft.util.EnumFacing;

@Mixin(EnumFacing.class)
public abstract class EnumFacingMixin implements IFacing
{

}
