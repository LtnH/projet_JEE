package fr.esgi.plage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FileDto {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("numero")
	private int numero;
	
	@JsonProperty("prixJournalier")
	private double prixJournalier;
}
