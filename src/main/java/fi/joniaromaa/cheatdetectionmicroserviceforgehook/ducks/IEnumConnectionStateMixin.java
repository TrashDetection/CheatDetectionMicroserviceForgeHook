package fi.joniaromaa.cheatdetectionmicroserviceforgehook.ducks;

import java.util.Map;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftPacket;

public interface IEnumConnectionStateMixin
{
    public Map<Integer, Class<? extends IMinecraftPacket>> getIncomings();
    public Map<Integer, Class<? extends IMinecraftPacket>> getOutgoings();
}
