package com.github.ssuite.slib.utility.chat;

import net.minecraft.server.v1_13_R2.IChatBaseComponent;
import net.minecraft.server.v1_13_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_13_R2.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class JSONChatUtility_1_13_R2 implements JSONChatUtility {
	
	public void sendJSONMessage(Player player, String message) {
		IChatBaseComponent comp = ChatSerializer.a(message);
		PacketPlayOutChat packet = new PacketPlayOutChat(comp);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}
	
}
