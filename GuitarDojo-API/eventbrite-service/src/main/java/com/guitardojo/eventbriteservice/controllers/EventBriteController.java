package com.guitardojo.eventbriteservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@RestController
public class EventBriteController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String token;
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public Object getEvents() {
		Object events = restTemplate.getForObject(token + "&expand=venue", Object.class);
		return events;
	}

}
