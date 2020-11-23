package com.cisco.app.dbconnector.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class WebControllerUI {
	Logger logger = LoggerFactory.getLogger(WebControllerUI.class);

	public WebControllerUI() {
		super();
	}

	@RequestMapping({ "/", "/logout", "/help", "/support", "/about", "/loggedin", "/endpoint", "/connector", "/GridView" })
	public String a() {
		return "forward:/index.html";
	}

}