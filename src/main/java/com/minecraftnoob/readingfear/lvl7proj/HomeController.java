package com.minecraftnoob.readingfear.lvl7proj;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
@Controller
public class HomeController {
	@GetMapping("/")
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	String Home() {
		return "redirect:swagger-ui.html";
	}
}