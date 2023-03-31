package fr.esgi.plage.business;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Pays {
	
	@Id
	private String code;
	private String nom;
	
	 @OneToMany(mappedBy="pays")
	 private List<Client> clients;
	 
	public Pays(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}

}
