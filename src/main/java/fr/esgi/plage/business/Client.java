package fr.esgi.plage.business;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Client extends Utilisateur {
 private LocalDateTime dateHeurInscription;

 @OneToMany(mappedBy="client")
 private List<Reservation> reservations;
 
 @ManyToOne
 @JoinColumn(name = "pays")
 private Pays pays;
 
 @ManyToOne
 @JoinColumn(name = "lienDeParente")
 private LienDeParente lienDeParente;

}
