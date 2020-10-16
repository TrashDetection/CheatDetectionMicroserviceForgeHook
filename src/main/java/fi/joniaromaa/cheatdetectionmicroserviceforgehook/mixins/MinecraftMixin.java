package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import fi.joniaromaa.cheatdetectionmicroserviceforgehook.MinecraftHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.shared.SharedMinecraftHooks;
import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin
{
	@Shadow public static byte[] memoryReserve = null;
	
	@Inject(method = "run", at = @At("HEAD"), cancellable = true)
	public void onRun(CallbackInfo ci)
	{
		ci.cancel();

		SharedMinecraftHooks.add(MinecraftHook.build());
		
		System.out.println("Stopped running the client");
	}
	
	@Inject(method = "getSystemTime", at = @At("HEAD"), cancellable = true)
    private static void getSystemTime(CallbackInfoReturnable<Long> cir)
    {
		//TODO: CHECK
		cir.setReturnValue(0L);
    }
}
