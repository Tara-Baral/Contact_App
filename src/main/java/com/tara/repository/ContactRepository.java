package com.tara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tara.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
