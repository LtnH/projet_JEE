package fr.esgi.plage.business;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class LienDeParente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nom;
	private float coefficient;
	
    public LienDeParente(String nom, float coefficient) {
			this.coefficient = coefficient;
			this.nom = nom;
    }

}
