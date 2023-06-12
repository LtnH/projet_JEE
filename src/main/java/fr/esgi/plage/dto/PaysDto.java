package fr.esgi.plage.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaysDto {
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("nom")
	private String nom;
	

}
