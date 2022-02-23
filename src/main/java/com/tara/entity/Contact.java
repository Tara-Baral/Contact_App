package com.tara.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTACT_ID")
	private Integer contactId;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	private String email;
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE")
	private LocalDate updatedDate;
}
