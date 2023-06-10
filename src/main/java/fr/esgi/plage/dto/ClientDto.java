package fr.esgi.plage.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.esgi.plage.business.LienDeParente;
import fr.esgi.plage.business.Pays;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDto extends UtilisateurDto{
	
	@JsonProperty("dateHeurInscription")
	private LocalDateTime dateHeurInscription;
	
	@JsonProperty("pays")
	private Pays pays;
	
	@JsonProperty("lienDeParente")
	private LienDeParente lienDeParente;
}
