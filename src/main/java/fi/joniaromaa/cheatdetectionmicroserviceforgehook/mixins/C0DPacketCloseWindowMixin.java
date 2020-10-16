package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.ICloseWindowIncomingPacket;
import net.minecraft.network.play.client.C0DPacketCloseWindow;

@Mixin(C0DPacketCloseWindow.class)
public abstract class C0DPacketCloseWindowMixin implements ICloseWindowIncomingPacket
{

}
