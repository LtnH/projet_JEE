package fr.esgi.plage.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Parasol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private byte numEmplacement;
	
	@ManyToOne
	private File file;
	
	@ManyToMany
	private List<Reservation> reservations;
	
   public Parasol(byte emplacement, File file) {
			this.file = file;
			this.numEmplacement = emplacement;
    }

}
