package fi.joniaromaa.cheatdetectionmicroserviceforgehook.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IChangeGameStateOutgoingPacaket;
import net.minecraft.network.play.server.S2BPacketChangeGameState;

@Mixin(S2BPacketChangeGameState.class)
public abstract class S2BPacketChangeGameStateMixin implements IChangeGameStateOutgoingPacaket
{
	private static final IChangeGameStateOutgoingPacaket.State[] STATES = new IChangeGameStateOutgoingPacaket.State[]
	{
		IChangeGameStateOutgoingPacaket.State.CANT_SLEEP,
		IChangeGameStateOutgoingPacaket.State.START_RAINING,
		IChangeGameStateOutgoingPacaket.State.STOP_RAINING,
		IChangeGameStateOutgoingPacaket.State.SET_GAMEMODE,
		IChangeGameStateOutgoingPacaket.State.END_CREDITS,
		IChangeGameStateOutgoingPacaket.State.DEMO,
		IChangeGameStateOutgoingPacaket.State.ARROW_HIT,
		IChangeGameStateOutgoingPacaket.State.RAIN_STRENGTH,
		IChangeGameStateOutgoingPacaket.State.THUNDER_STRENGTH,
		IChangeGameStateOutgoingPacaket.State.GUARDIAN_CURSE
	};
	
    @Shadow private int state;
    @Shadow private float field_149141_c;

	@Override
	public State getState()
	{
		if (this.state >= S2BPacketChangeGameStateMixin.STATES.length)
		{
			return null;
		}
		
		return S2BPacketChangeGameStateMixin.STATES[this.state];
	}
	
	@Override
	public float getValue()
	{
		return this.field_149141_c;
	}
}
