package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import java.util.IdentityHashMap;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IIncomingEntityActionIncomingPacket;
import net.minecraft.network.play.client.C0BPacketEntityAction;

@Mixin(C0BPacketEntityAction.class)
public abstract class C0BPacketEntityActionMixin implements IIncomingEntityActionIncomingPacket
{
	private static final IdentityHashMap<C0BPacketEntityAction.Action, IIncomingEntityActionIncomingPacket.Action> MAPPED = new IdentityHashMap<>();

	static
	{
		C0BPacketEntityActionMixin.MAPPED.put(C0BPacketEntityAction.Action.START_SNEAKING, IIncomingEntityActionIncomingPacket.Action.START_SNEAKING);
		C0BPacketEntityActionMixin.MAPPED.put(C0BPacketEntityAction.Action.STOP_SNEAKING, IIncomingEntityActionIncomingPacket.Action.STOP_SNEAKING);
		C0BPacketEntityActionMixin.MAPPED.put(C0BPacketEntityAction.Action.STOP_SLEEPING, IIncomingEntityActionIncomingPacket.Action.STOP_SLEEPING);
		C0BPacketEntityActionMixin.MAPPED.put(C0BPacketEntityAction.Action.START_SPRINTING, IIncomingEntityActionIncomingPacket.Action.START_SPRINTING);
		C0BPacketEntityActionMixin.MAPPED.put(C0BPacketEntityAction.Action.STOP_SPRINTING, IIncomingEntityActionIncomingPacket.Action.STOP_SPRINTING);
		C0BPacketEntityActionMixin.MAPPED.put(C0BPacketEntityAction.Action.RIDING_JUMP, IIncomingEntityActionIncomingPacket.Action.RIDING_JUMP);
		C0BPacketEntityActionMixin.MAPPED.put(C0BPacketEntityAction.Action.OPEN_INVENTORY, IIncomingEntityActionIncomingPacket.Action.OPEN_INVENTORY);
	}

	@Shadow private int entityID;
    @Shadow private C0BPacketEntityAction.Action action;
    @Shadow private int auxData;
    
	@Override
	public int getEntityId()
	{
		return this.entityID;
	}

	@Override
    public IIncomingEntityActionIncomingPacket.Action getAction()
    {
    	return C0BPacketEntityActionMixin.MAPPED.get(this.action);
    }

	@Override
	public int getAuxData()
	{
		return this.auxData;
	}
}
