package fr.esgi.plage.business;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Statut {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nom;
	
	public Statut(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "statut")
	public List<Reservation> reservationList;

}
