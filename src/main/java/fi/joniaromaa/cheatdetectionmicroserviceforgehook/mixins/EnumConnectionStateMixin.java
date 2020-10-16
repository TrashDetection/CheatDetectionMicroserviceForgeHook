package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.HashMap;
import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import fi.joniaromaa.cheatdetectionmicroserviceforgehook.ducks.IEnumConnectionStateMixin;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftPacket;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.Packet;

@Mixin(EnumConnectionState.class)
public abstract class EnumConnectionStateMixin implements IEnumConnectionStateMixin
{
	private Map<Integer, Class<? extends IMinecraftPacket>> incomings = new HashMap<>();
	private Map<Integer, Class<? extends IMinecraftPacket>> outgoings = new HashMap<>();
	
    @Inject(method = "registerPacket", at = @At("RETURN"))
    private void onRegisterPacket(EnumPacketDirection direction, Class<? extends Packet<?>> packetClass, CallbackInfoReturnable<EnumConnectionState> cir)
    {
    	Map<Integer, Class<? extends IMinecraftPacket>> packets;
    	if (direction == EnumPacketDirection.CLIENTBOUND)
    	{
    		packets = this.outgoings;
    	}
    	else if (direction == EnumPacketDirection.SERVERBOUND)
    	{
    		packets = this.incomings;
    	}
    	else
    	{
    		throw new IllegalArgumentException(direction.toString());
    	}

    	packets.put(packets.size(), packetClass.asSubclass(IMinecraftPacket.class));
    }
    
    public Map<Integer, Class<? extends IMinecraftPacket>> getIncomings()
    {
    	return this.incomings;
    }
    
    public Map<Integer, Class<? extends IMinecraftPacket>> getOutgoings()
    {
    	return this.outgoings;
    }
}
