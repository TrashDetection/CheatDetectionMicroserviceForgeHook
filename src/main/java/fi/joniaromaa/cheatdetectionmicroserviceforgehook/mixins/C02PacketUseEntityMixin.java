package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.IdentityHashMap;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IUseEntityIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IVectorPos;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.util.Vec3;

@Mixin(C02PacketUseEntity.class)
public abstract class C02PacketUseEntityMixin implements IUseEntityIncomingPacket
{
	private static final IdentityHashMap<C02PacketUseEntity.Action, IUseEntityIncomingPacket.Action> MAPPED = new IdentityHashMap<>();

	static
	{
		C02PacketUseEntityMixin.MAPPED.put(C02PacketUseEntity.Action.INTERACT, IUseEntityIncomingPacket.Action.INTERACT);
		C02PacketUseEntityMixin.MAPPED.put(C02PacketUseEntity.Action.ATTACK, IUseEntityIncomingPacket.Action.ATTACK);
		C02PacketUseEntityMixin.MAPPED.put(C02PacketUseEntity.Action.INTERACT_AT, IUseEntityIncomingPacket.Action.INTERACT_AT);
	}
	
    @Shadow private int entityId;
    @Shadow private C02PacketUseEntity.Action action;
    @Shadow private Vec3 hitVec;
    
	@Override
	public int getEntityId()
	{
		return this.entityId;
	}
	
	@Override
	public Action getAction()
	{
		return C02PacketUseEntityMixin.MAPPED.get(this.action);
	}

	@Override
	public IVectorPos getPosition()
	{
		return (IVectorPos)this.hitVec;
	}
}
