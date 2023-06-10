package fr.esgi.plage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LienDeParente {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("nom")
	private String nom;
	
	@JsonProperty("coefficient")
	private float coefficient;

}
