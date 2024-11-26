package es.guillermoll.docker_demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class HolaMundo {

	public String home() {
		return "Hello Docker World";
	}
}