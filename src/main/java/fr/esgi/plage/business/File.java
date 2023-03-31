package fr.esgi.plage.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class File {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private byte numero;
	private double prixJournalier;
	
	 @OneToMany(mappedBy="file")
	 private List<Parasol> parasols;
	
	 public File(int numero, double prix) {
			this.numero = (byte) numero;
			this.prixJournalier = prix;
		}
}
