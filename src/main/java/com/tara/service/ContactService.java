package com.tara.service;

import java.util.List;

import com.tara.bindings.ContactForm;

public interface ContactService {

	public String saveContact(ContactForm form);
	
	public List<ContactForm> viewContact();
	
	public ContactForm editContact(Integer contactId);
	
	public List<ContactForm> deleteContact(Integer contactId);
}
