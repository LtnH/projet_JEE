package fr.esgi.plage.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ClientDto extends UtilisateurDto{
	
	@JsonProperty("dateHeurInscription")
	private LocalDateTime dateHeurInscription;
	
}
