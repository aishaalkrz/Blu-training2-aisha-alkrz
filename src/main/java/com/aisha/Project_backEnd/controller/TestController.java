package com.aisha.Project_backEnd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/students")
public class TestController {
	
	
	
	@RequestMapping("/test")
	public String Test() {
		return "Hello Aisha ..";
	}

}
