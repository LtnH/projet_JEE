package fr.esgi.plage.business;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Client extends Utilisateur {
 private LocalDateTime dateHeurInscription;
 
 @OneToMany(mappedBy="client")
 private List<Reservation> reservations;
 
 @ManyToOne
 private Pays pays;
 
 @ManyToOne
 private LienDeParente lienDeParente;
 
}
