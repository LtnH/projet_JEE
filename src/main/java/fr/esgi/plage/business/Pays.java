package fr.esgi.plage.business;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Pays {
	
	@Id
	private String code;
	private String nom;

//	@OneToMany(mappedBy="pays")
	@OneToMany(fetch = FetchType.LAZY)
	private List<Client> clients;
	 
	public Pays(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}

}
