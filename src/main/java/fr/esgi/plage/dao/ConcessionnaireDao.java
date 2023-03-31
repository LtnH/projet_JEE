package fr.esgi.plage.dao;

import fr.esgi.plage.business.Concessionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionnaireDao extends JpaRepository<Concessionnaire, Long> {
}
