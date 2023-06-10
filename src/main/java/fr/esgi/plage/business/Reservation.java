package fr.esgi.plage.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
	private Byte moisExpiration;
	
	@Min(23)
	private Byte anneeExpiration;
	
	@ManyToOne
	@JoinColumn(name = "client")
	private Client client;
	
	@ManyToOne
	private Concessionnaire concessionnaire;
	
	@ManyToMany
	private List<Parasol> parasols;
	
	@ManyToOne
	@JoinColumn(name = "statut")
	private Statut statut;

	public void setMontantAReglerEnEuro(double montantAReglerEnEuro) {
//		montantAReglerEnEuro = montantAReglerEnEuro * (1.0  - this.client.getLienDeParente().getCoefficient());

		this.montantAReglerEnEuro = montantAReglerEnEuro;
	}
}
