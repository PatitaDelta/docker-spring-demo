package es.guillermoll.docker_demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HolaMundo {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}
}