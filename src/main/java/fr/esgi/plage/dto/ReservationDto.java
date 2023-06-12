package fr.esgi.plage.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.business.Concessionnaire;
import fr.esgi.plage.business.Parasol;
import fr.esgi.plage.business.Statut;
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
	private Byte moisExpiration;
	
	@JsonProperty("anneeExpiration")
	private Byte anneeExpiration;

	@JsonProperty("client")
	private Client client;

	@JsonProperty("parasol")
	private List<Parasol> parasol;

	@JsonProperty("concessionnaire")
	private Concessionnaire concessionnaire;

	@JsonProperty("statut")
	private Statut statut;
}
