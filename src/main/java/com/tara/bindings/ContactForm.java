package com.tara.bindings;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {

	private Integer contactId;
	private String contactName;
	private String email;
	private Long contactNumber;
	private String activeSw;
	private LocalDate createdDate;
	private LocalDate updatedDate;
}
