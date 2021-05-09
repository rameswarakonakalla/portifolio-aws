package com.cognizant.dailymutualfund.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@EnableSwagger2
	public class SwaggerUIController {
	@RequestMapping(value = "/")
	public String index() {
	return "redirect:swagger-ui.html";
	}
	
}
