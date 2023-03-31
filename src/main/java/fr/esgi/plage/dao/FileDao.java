package fr.esgi.plage.dao;

import fr.esgi.plage.business.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDao extends JpaRepository<File, Long> {
    File findByNumero(byte i);
}
