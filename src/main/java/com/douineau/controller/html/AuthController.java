package com.douineau.controller.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/authenticate")
	public String authenticate() {
		return "authenticate";
	}
}
