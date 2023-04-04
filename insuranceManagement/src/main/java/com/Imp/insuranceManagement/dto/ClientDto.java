package com.Imp.insuranceManagement.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
	private Long id;

	private String name;

	private LocalDate dateOfBirth;

	private String address;

	private String contactInformation;
}
