package fr.esgi.plage.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReservationDto {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("dateDebut")
	private LocalDate dateDebut;
	
	@JsonProperty("dateFin")
	private LocalDate dateFin;	
	
	@JsonProperty("montantAReglerEnEuro")
	private double montantAReglerEnEuro;
	
	@JsonProperty("remarques")
	private String remarques;
	
	@JsonProperty("numeroCarte")
	private String numeroCarte;
	
	@JsonProperty("cryptogramme")
	private String cryptogramme;
	
	@JsonProperty("moisExpiration")
	private byte moisExpiration;
	
	@JsonProperty("anneeExpiration")
	private byte anneeExpiration;

}
