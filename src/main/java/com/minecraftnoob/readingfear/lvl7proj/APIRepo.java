package com.minecraftnoob.readingfear.lvl7proj;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
@Repository
public class APIRepo {
	WebClient WC = WebClient.create();
	String Get(String URL) {
		try {
			String Body = WC.get().uri(URL).retrieve().bodyToMono(String.class).block();
			if (Body.isEmpty())
				return "Error";
			return Body;
		} catch(Exception Err) {
			Err.printStackTrace();
			return "Error";
		}
	}
	String GetProfile(String ID) {
		return Get("https://sessionserver.mojang.com/session/minecraft/profile/" + ID);
	}
	String GetID(String Name) {
		String Body = Get("https://api.mojang.com/users/profiles/minecraft/" + Name);
		if (Body.equals("Error"))
			return "Error";
		return new JSONObject(Body).getString("id");
	}
}