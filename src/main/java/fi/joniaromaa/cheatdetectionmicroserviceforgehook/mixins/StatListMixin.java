package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;

@Mixin(StatList.class)
public abstract class StatListMixin
{
	private static final StatBase[] WTF_MOJANG = new StatBase[32000];
	
    @Shadow @Final @Mutable public static StatBase[] mineBlockStatArray = StatListMixin.WTF_MOJANG;
    @Shadow @Final @Mutable public static StatBase[] objectCraftStats = StatListMixin.WTF_MOJANG;
    @Shadow @Final @Mutable public static StatBase[] objectUseStats = StatListMixin.WTF_MOJANG;
    @Shadow @Final @Mutable public static StatBase[] objectBreakStats = StatListMixin.WTF_MOJANG;
    
	@Inject(method = "init", at = @At("HEAD"), cancellable = true)
	private static void init(CallbackInfo ci)
    {
		ci.cancel();
    }
}
