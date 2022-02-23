package com.tara.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tara.bindings.ContactForm;
import com.tara.entity.Contact;
import com.tara.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public String saveContact(ContactForm form) {
		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSw("YES");
		entity = contactRepo.save(entity);
		if(entity.getContactId() != 0) {
			return "Contact saved Successfully !!!";
		}
		else {
			return "Contact Not saved ...";
		}
		
	}

	@Override
	public List<ContactForm> viewContact() {
		List<Contact> findAll = contactRepo.findAll();
		List<ContactForm> dataList = new ArrayList<>();
		for(Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			Contact entity = findById.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		return viewContact();
	}

}
