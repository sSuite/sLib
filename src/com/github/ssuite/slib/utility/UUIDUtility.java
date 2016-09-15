package com.github.ssuite.slib.utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

public class UUIDUtility {
	
	private static final String UUID_API = "https://api.mojang.com/users/profiles/minecraft/%NAME%";
	private static final String NAME_API = "https://api.mojang.com/user/profiles/%UUID%/names";
	
	/**
	 * Formats a UUID according to v4 standards.
	 *
	 * @param uuid the UUID string
	 * @return the formatted UUID string
	 */
	public static String formatUUID(String uuid) {
		return uuid.substring(0, 8) + uuid.substring(8, 12) + uuid.substring(12, 16) + uuid.substring(16, 20)
				+ uuid.substring(20);
	}
	
	/**
	 * Gets the username associated with the UUID.
	 *
	 * @param uuid the UUID
	 * @return the username or null if no user can be found
	 */
	public static String getNameFromUUID(UUID uuid) {
		return getNameFromUUID(uuid.toString());
	}
	
	/**
	 * Gets the username associated with the UUID.
	 *
	 * @param uuid the UUID
	 * @return the username or null if no user can be found
	 */
	public static String getNameFromUUID(String uuid) {
		try {
			String response = HTTPUtility.get(NAME_API.replace("%UUID%", uuid.replace("-", "")));
			JSONArray nameList = (JSONArray) JSONValue.parse(response);
			
			return (String) ((JSONObject) nameList.get(nameList.size() - 1)).get("name");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Gets the UUID associated with the username.
	 *
	 * @param name the username
	 * @return the UUID
	 */
	public static UUID getUUIDFromName(String name) {
		try {
			String response = HTTPUtility.get(UUID_API.replace("%NAME%", name));
			JSONObject uuidInformation = (JSONObject) JSONValue.parse(response);
			
			return UUID.fromString(formatUUID((String) uuidInformation.get("id")));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
