package fr.esgi.plage.dao;

import fr.esgi.plage.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
}
