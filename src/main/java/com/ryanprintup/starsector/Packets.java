package com.ryanprintup.starsector;

import com.ryanprintup.starsector.packets.BurnContainerPacket;
import com.ryanprintup.starsector.packets.CelestialRequestPacket;
import com.ryanprintup.starsector.packets.CelestialResponsePacket;
import com.ryanprintup.starsector.packets.ChatRecievedPacket;
import com.ryanprintup.starsector.packets.ChatSentPacket;
import com.ryanprintup.starsector.packets.ClearContainerPacket;
import com.ryanprintup.starsector.packets.ClientConnectPacket;
import com.ryanprintup.starsector.packets.ClientContextUpdatePacket;
import com.ryanprintup.starsector.packets.ClientDisconnectPacket;
import com.ryanprintup.starsector.packets.CloseContainerPacket;
import com.ryanprintup.starsector.packets.ConnectWirePacket;
import com.ryanprintup.starsector.packets.ConnectionResponsePacket;
import com.ryanprintup.starsector.packets.DamageNotificationPacket;
import com.ryanprintup.starsector.packets.DamageTileGroupPacket;
import com.ryanprintup.starsector.packets.DamageTilePacket;
import com.ryanprintup.starsector.packets.DisconnectAllWiresPacket;
import com.ryanprintup.starsector.packets.DisconnectResponsePacket;
import com.ryanprintup.starsector.packets.EntityCreatePacket;
import com.ryanprintup.starsector.packets.EntityDestroyPacket;
import com.ryanprintup.starsector.packets.EntityInteractPacket;
import com.ryanprintup.starsector.packets.EntityInteractResultPacket;
import com.ryanprintup.starsector.packets.EntityUpdatePacket;
import com.ryanprintup.starsector.packets.EnvironmentUpdatePacket;
import com.ryanprintup.starsector.packets.GiveItemPacket;
import com.ryanprintup.starsector.packets.HandshakeChallengePacket;
import com.ryanprintup.starsector.packets.HandshakeResponsePacket;
import com.ryanprintup.starsector.packets.HeartbeatPacket;
import com.ryanprintup.starsector.packets.ItemApplyInContainerPacket;
import com.ryanprintup.starsector.packets.ModifyTileListPacket;
import com.ryanprintup.starsector.packets.OpenContainerPacket;
import com.ryanprintup.starsector.packets.ProtocolVersionPacket;
import com.ryanprintup.starsector.packets.RequestDropPacket;
import com.ryanprintup.starsector.packets.SpawnEntityPacket;
import com.ryanprintup.starsector.packets.StartCraftingInContainerPacket;
import com.ryanprintup.starsector.packets.StatusEffectRequestPacket;
import com.ryanprintup.starsector.packets.StopCraftingInContainerPacket;
import com.ryanprintup.starsector.packets.SwapInContainerPacket;
import com.ryanprintup.starsector.packets.SwapInContainerResultPacket;
import com.ryanprintup.starsector.packets.TileArrayUpdatePacket;
import com.ryanprintup.starsector.packets.TileDamageUpdatePacket;
import com.ryanprintup.starsector.packets.TileLiquidUpdatePacket;
import com.ryanprintup.starsector.packets.TileModificationFailurePacket;
import com.ryanprintup.starsector.packets.TileUpdatePacket;
import com.ryanprintup.starsector.packets.UniversalTimeUpdatePacket;
import com.ryanprintup.starsector.packets.UpdateWorldPropertiesPacket;
import com.ryanprintup.starsector.packets.WarpCommandPacket;
import com.ryanprintup.starsector.packets.WorldClientStateUpdatePacket;
import com.ryanprintup.starsector.packets.WorldStartPacket;
import com.ryanprintup.starsector.packets.WorldStopPacket;

public enum Packets
{
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
	private final Class<? extends Object> clazz;
	
	private Packets(int id, Class<? extends Object> clazz)
	{
		this.id = id;
		this.clazz = clazz;
	}
	
	public int getId()
	{
		return id;
	}
	
	public Class getPacketClass()
	{
		return clazz;
	}
	
	public Object newInstance() throws InstantiationException, IllegalAccessException
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