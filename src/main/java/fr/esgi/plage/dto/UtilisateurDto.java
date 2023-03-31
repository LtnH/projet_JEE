package fr.esgi.plage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UtilisateurDto {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("nom")
	private String nom;
	
	@JsonProperty("prenom")
	private String prenom;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("mdp")
	private String mdp;

}
