package com.aisha.Project_backEnd.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/test")
	public String Test() {
		return "Hello ";
	}

}
