package com.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FrontendRedirect {
	
	@GetMapping(path = "/")
	public ModelAndView index(){
		
	    return new ModelAndView("index.html");
    }

}
