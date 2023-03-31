package fr.esgi.plage.dao;

import fr.esgi.plage.business.LienDeParente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LienDeParenteDao extends JpaRepository<LienDeParente, Long> {
}
