package fr.esgi.plage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ConcessionnaireDto extends UtilisateurDto {
	
	@JsonProperty("numeroDeTelephone")
	private String numeroDeTelephone;
}
