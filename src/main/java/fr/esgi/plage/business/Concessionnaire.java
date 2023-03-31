package fr.esgi.plage.business;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Concessionnaire extends Utilisateur {

	private String numeroDeTelephone;
}
