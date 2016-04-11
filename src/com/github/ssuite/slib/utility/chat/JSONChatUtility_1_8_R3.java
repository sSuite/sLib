package com.github.ssuite.slib.utility.chat;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class JSONChatUtility_1_8_R3 implements JSONChatUtility {

	public void sendJSONMessage(Player player, String message) {
		IChatBaseComponent comp = ChatSerializer.a(message);
		PacketPlayOutChat packet = new PacketPlayOutChat(comp);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

}
