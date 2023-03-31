package fr.esgi.plage.dao;

import fr.esgi.plage.business.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
}
