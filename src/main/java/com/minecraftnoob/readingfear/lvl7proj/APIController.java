package com.minecraftnoob.readingfear.lvl7proj;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@CrossOrigin
public class APIController {
	APIService Service;
	APIController(APIService Service) {
		this.Service = Service;
	}
	@GetMapping("/getProfile")
	@ApiOperation(value = "Gets a player's profile", notes = "Query can be a username or UUID", response = String.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Player found"), @ApiResponse(code = 404, message = "Player not found")})
	String GetProfile(@RequestParam(value = "q") String Query) {
		String Profile = Service.GetProfile(Query);
		if (Profile.equals("Error"))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
		System.out.println(Profile);
		return "[" + Profile + "]";
	}
}