package com.tara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tara.bindings.ContactForm;
import com.tara.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveContact(@RequestBody ContactForm form){
		String status = service.saveContact(form);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<ContactForm>> viewContacts(){
		List<ContactForm> viewContact = service.viewContact();
		return new ResponseEntity<>(viewContact, HttpStatus.OK);
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<ContactForm> editContact(@PathVariable("id") Integer contactId){
		ContactForm form = service.editContact(contactId);
		return new ResponseEntity<>(form, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<ContactForm>> deleteContact(@PathVariable("id") Integer contactId){
		List<ContactForm> deleteContact = service.deleteContact(contactId);
		return new ResponseEntity<>(deleteContact, HttpStatus.OK);
	}
}
