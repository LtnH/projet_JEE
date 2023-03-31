package fr.esgi.plage.dao;

import fr.esgi.plage.business.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutDao extends JpaRepository<Statut, Long> {
}
