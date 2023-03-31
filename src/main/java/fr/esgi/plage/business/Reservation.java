package fr.esgi.plage.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private LocalDate dateDebut;
	private LocalDate dateFin;	
	private double montantAReglerEnEuro;
	private String remarques;
	private String numeroCarte;
	private String cryptogramme;
	
	@Range(min=1,max=12)
	private byte moisExpiration;
	
	@Min(2023)
	private byte anneeExpiration;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Concessionnaire concessionnaire;
	
	@OneToMany
	private List<Parasol> parasols;
	
	@ManyToOne
	private Statut statut;
	

}
