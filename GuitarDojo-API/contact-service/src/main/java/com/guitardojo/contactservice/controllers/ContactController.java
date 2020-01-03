package com.guitardojo.contactservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guitardojo.guitardojodata.models.Contact;
import com.guitardojo.guitardojodata.repositories.ContactRepository;


@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepo;
	
	
	@PostMapping("/create")
	public Contact createContact(@RequestBody Contact contact) {
		return contactRepo.save(contact);
	}
	
	@GetMapping("/getAll") 
		public List<Contact> getAll() {
			return contactRepo.findAll();
	}
	

}
