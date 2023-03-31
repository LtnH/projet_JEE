package fr.esgi.plage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StatutDto {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("nom")
	private String nom;

}
