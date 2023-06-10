package fr.esgi.plage.dao;

import fr.esgi.plage.business.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysDao extends JpaRepository<Pays, String> {
    Pays findByCode(String code);
}
