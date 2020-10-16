package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IAnimationIncomingPacket;
import net.minecraft.network.play.client.C0APacketAnimation;

@Mixin(C0APacketAnimation.class)
public abstract class C0APacketAnimationMixin implements IAnimationIncomingPacket
{
}
