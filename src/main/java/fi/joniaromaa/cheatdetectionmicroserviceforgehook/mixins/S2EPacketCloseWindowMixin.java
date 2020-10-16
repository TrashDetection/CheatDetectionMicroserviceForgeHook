package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.ICloseWindowOutgoingPacket;
import net.minecraft.network.play.server.S2EPacketCloseWindow;

@Mixin(S2EPacketCloseWindow.class)
public abstract class S2EPacketCloseWindowMixin implements ICloseWindowOutgoingPacket
{

}
