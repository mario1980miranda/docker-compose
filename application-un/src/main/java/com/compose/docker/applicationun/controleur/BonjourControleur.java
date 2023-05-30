package com.compose.docker.applicationun.controleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class BonjourControleur {

	@GetMapping("bienvenue")
	public String bienvenue() {
		return "Bienvenue au monde des Controleurs!";
	}
}
