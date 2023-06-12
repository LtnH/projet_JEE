package fr.esgi.plage.business;

import java.util.List;

import javax.persistence.*;

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
