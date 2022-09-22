package com.minecraftnoob.readingfear.lvl7proj;
import java.util.UUID;
import org.springframework.stereotype.Service;
@Service
public class APIService {
	APIRepo Repo;
	APIService(APIRepo Repo) {
		this.Repo = Repo;
	}
	String GetProfile(String Query) {
		try {
			UUID.fromString(Query);
			return Repo.GetProfile(Query);
		} catch(IllegalArgumentException Err) {
			String ID = Repo.GetID(Query);
			if (ID.equals("Error"))
				return "Error";
			return Repo.GetProfile(ID);
		}
	}
}