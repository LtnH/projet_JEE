package fr.esgi.plage.dao;

import fr.esgi.plage.business.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {
}
