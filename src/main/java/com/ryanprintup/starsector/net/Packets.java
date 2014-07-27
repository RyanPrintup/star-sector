package com.ryanprintup.starsector.net;

import com.ryanprintup.starsector.net.packets.BurnContainerPacket;
import com.ryanprintup.starsector.net.packets.CelestialRequestPacket;
import com.ryanprintup.starsector.net.packets.CelestialResponsePacket;
import com.ryanprintup.starsector.net.packets.ChatRecievedPacket;
import com.ryanprintup.starsector.net.packets.ChatSentPacket;
import com.ryanprintup.starsector.net.packets.ClearContainerPacket;
import com.ryanprintup.starsector.net.packets.ClientConnectPacket;
import com.ryanprintup.starsector.net.packets.ClientContextUpdatePacket;
import com.ryanprintup.starsector.net.packets.ClientDisconnectPacket;
import com.ryanprintup.starsector.net.packets.CloseContainerPacket;
import com.ryanprintup.starsector.net.packets.ConnectWirePacket;
import com.ryanprintup.starsector.net.packets.ConnectionResponsePacket;
import com.ryanprintup.starsector.net.packets.DamageNotificationPacket;
import com.ryanprintup.starsector.net.packets.DamageTileGroupPacket;
import com.ryanprintup.starsector.net.packets.DamageTilePacket;
import com.ryanprintup.starsector.net.packets.DisconnectAllWiresPacket;
import com.ryanprintup.starsector.net.packets.DisconnectResponsePacket;
import com.ryanprintup.starsector.net.packets.EntityCreatePacket;
import com.ryanprintup.starsector.net.packets.EntityDestroyPacket;
import com.ryanprintup.starsector.net.packets.EntityInteractPacket;
import com.ryanprintup.starsector.net.packets.EntityInteractResultPacket;
import com.ryanprintup.starsector.net.packets.EntityUpdatePacket;
import com.ryanprintup.starsector.net.packets.EnvironmentUpdatePacket;
import com.ryanprintup.starsector.net.packets.GiveItemPacket;
import com.ryanprintup.starsector.net.packets.HandshakeChallengePacket;
import com.ryanprintup.starsector.net.packets.HandshakeResponsePacket;
import com.ryanprintup.starsector.net.packets.HeartbeatPacket;
import com.ryanprintup.starsector.net.packets.ItemApplyInContainerPacket;
import com.ryanprintup.starsector.net.packets.ModifyTileListPacket;
import com.ryanprintup.starsector.net.packets.OpenContainerPacket;
import com.ryanprintup.starsector.net.packets.ProtocolVersionPacket;
import com.ryanprintup.starsector.net.packets.RequestDropPacket;
import com.ryanprintup.starsector.net.packets.SpawnEntityPacket;
import com.ryanprintup.starsector.net.packets.StartCraftingInContainerPacket;
import com.ryanprintup.starsector.net.packets.StatusEffectRequestPacket;
import com.ryanprintup.starsector.net.packets.StopCraftingInContainerPacket;
import com.ryanprintup.starsector.net.packets.SwapInContainerPacket;
import com.ryanprintup.starsector.net.packets.SwapInContainerResultPacket;
import com.ryanprintup.starsector.net.packets.TileArrayUpdatePacket;
import com.ryanprintup.starsector.net.packets.TileDamageUpdatePacket;
import com.ryanprintup.starsector.net.packets.TileLiquidUpdatePacket;
import com.ryanprintup.starsector.net.packets.TileModificationFailurePacket;
import com.ryanprintup.starsector.net.packets.TileUpdatePacket;
import com.ryanprintup.starsector.net.packets.UniversalTimeUpdatePacket;
import com.ryanprintup.starsector.net.packets.UpdateWorldPropertiesPacket;
import com.ryanprintup.starsector.net.packets.WarpCommandPacket;
import com.ryanprintup.starsector.net.packets.WorldClientStateUpdatePacket;
import com.ryanprintup.starsector.net.packets.WorldStartPacket;
import com.ryanprintup.starsector.net.packets.WorldStopPacket;

public enum Packets
{	
	/**
	*Packet information from http://starbound-dev.org/
	*/
	
	PROTOCOLVERSION(0, ProtocolVersionPacket.class),
	CONNECTIONRESPONSE(1, ConnectionResponsePacket.class),
	DISCONNECTRESPONSE(2, DisconnectResponsePacket.class),
	HANDSHAKECHALLENGE(3, HandshakeChallengePacket.class),
	CHATRECIEVED(4, ChatRecievedPacket.class),
	UNIVERSALTIMEUPDATE(5, UniversalTimeUpdatePacket.class),
	CELESTIALRESPONSE(6, CelestialResponsePacket.class),
	CLIENTCONNECT(7, ClientConnectPacket.class),
	CLIENTDISCONNECT(8, ClientDisconnectPacket.class),
	HANDSHAKERESPONSE(9, HandshakeResponsePacket.class),
	WARPCOMMAND(10, WarpCommandPacket.class),
	CHATSENT(11, ChatSentPacket.class),
	CELESTIALREQUEST(12, CelestialRequestPacket.class),
	CLIENTCONTEXTUPDATE(13, ClientContextUpdatePacket.class),
	WORLDSTART(14, WorldStartPacket.class),
	WORLDSTOP(15, WorldStopPacket.class),
	TILEARRAYUPDATE(16, TileArrayUpdatePacket.class),
	TILEUPDATE(17, TileUpdatePacket.class),
	TILELIQUIDUPDATE(18, TileLiquidUpdatePacket.class),
	TILEDAMAGEUPDATE(19, TileDamageUpdatePacket.class),
	TILEMODIFICATIONFAILURE(20, TileModificationFailurePacket.class),
	GIVEITEM(21, GiveItemPacket.class),
	SWAPINCONTAINERRESULT(22, SwapInContainerResultPacket.class),
	ENVIORMENTUPDATE(23, EnvironmentUpdatePacket.class),
	ENTITYINTERACTRESULT(24, EntityInteractResultPacket.class),
	MODIFYTILELIST(25, ModifyTileListPacket.class),
	DAMAGETILE(26, DamageTilePacket.class),
	DAMAGETILEGROUP(27, DamageTileGroupPacket.class),
	REQUESTDROP(28, RequestDropPacket.class),
	SPAWNENTITY(29, SpawnEntityPacket.class),
	ENTITYINTERACT(30, EntityInteractPacket.class),
	CONNECTWIRE(31, ConnectWirePacket.class),
	DISCONNECTALLWIRES(32, DisconnectAllWiresPacket.class),
	OPENCONTAINER(33, OpenContainerPacket.class),
	CLOSECONTAINER(34, CloseContainerPacket.class),
	SWAPINCONTAINER(35, SwapInContainerPacket.class),
	ITEMAPPLYINCONTAINER(36, ItemApplyInContainerPacket.class),
	STARTCRAFTINGINCONTAINER(37, StartCraftingInContainerPacket.class),
	STOPCRAFTINGINCONTAINER(38, StopCraftingInContainerPacket.class),
	BURNCONTAINER(39, BurnContainerPacket.class),
	CLEARCONTAINER(40, ClearContainerPacket.class),
	WORLDCLIENTSTATEUPDATE(41, WorldClientStateUpdatePacket.class),
	ENTITYCREATE(42, EntityCreatePacket.class),
	ENTITYUPDATE(43, EntityUpdatePacket.class),
	ENTITYDESTROY(44, EntityDestroyPacket.class),
	DAMAGENOTIFICATION(45, DamageNotificationPacket.class),
	STATUSEFFECTREQUEST(46, StatusEffectRequestPacket.class),
	UPDATEWORLDPROPERTIES(47, UpdateWorldPropertiesPacket.class),
	HEARTBEAT(48, HeartbeatPacket.class);

	private int id;
	private final Class<? extends Packet> clazz;
	
	private Packets(int id, Class<? extends Packet> clazz)
	{
		this.id = id;
		this.clazz = clazz;
	}
	
	public int getId()
	{
		return id;
	}
	
	public Class<? extends Packet> getPacketClass()
	{
		return clazz;
	}
	
	public Packet getClassInstance() throws InstantiationException, IllegalAccessException
	{
		return clazz.newInstance();
	}
	
	public static boolean contains(int id)
	{
		for (Packets packet : Packets.values()) {
			if (packet.getId() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	public static Packets get(int id)
	{
		for (Packets packet : Packets.values()) {
			if (packet.getId() == id) {
				return packet;
			}
		}
		
		return null;
	}
}