package fr.esgi.plage.service.impl;

import java.time.*;
import java.util.List;

import fr.esgi.plage.exception.ReservationDateInvalideException;
import org.springframework.stereotype.Service;

import fr.esgi.plage.business.Reservation;
import fr.esgi.plage.dao.ReservationDao;
import fr.esgi.plage.dto.ReservationDto;
import fr.esgi.plage.exception.ClientInexistantException;
import fr.esgi.plage.mapper.ReservationMapper;
import fr.esgi.plage.service.ReservationService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

	private ReservationDao reservationDao;
	
	private ReservationMapper reservationMapper;
	@Override
	public Reservation getReservation(Long id) {
		return reservationDao.findById(id).orElse(null);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationDao.findAll();
	}

	
	@Override
	public Reservation modifyReservation(ReservationDto reservationDto) {
		if (reservationDto.getId()==null) {
            throw new ClientInexistantException("Il manque l'id du client");
        }
	    Reservation reservationAModifier = reservationDao.findById(reservationDto.getId()).orElseThrow(() -> new ClientInexistantException("Cette réservation n'existe pas"));
	    reservationAModifier.setRemarques(reservationDto.getRemarques());
	    reservationAModifier.setAnneeExpiration(reservationDto.getAnneeExpiration());
	    reservationAModifier.setMoisExpiration(reservationDto.getMoisExpiration());
	    reservationAModifier.setCryptogramme(reservationDto.getCryptogramme());
	    reservationAModifier.setNumeroCarte(reservationDto.getNumeroCarte());
	    reservationAModifier.setClient(reservationDto.getClient());
	    reservationAModifier.setParasols(reservationDto.getParasol());
	    reservationAModifier.setConcessionnaire(reservationDto.getConcessionnaire());
        reservationAModifier.setStatut(reservationDto.getStatut());

        if (reservationDto.getId().equals(reservationAModifier.getId())) {
			reservationAModifier.setMontantAReglerEnEuro(reservationDto.getMontantAReglerEnEuro() * (1 - reservationDto.getClient().getLienDeParente().getCoefficient()));

			if (reservationDto.getDateDebut().isAfter(LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 1)) &&
			reservationDto.getDateDebut().isBefore(LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15)) &&
			reservationDto.getDateFin().isAfter(LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 1)) &&
			reservationDto.getDateFin().isBefore(LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15))
			) {
				reservationAModifier.setDateDebut(reservationDto.getDateDebut());
				reservationAModifier.setDateFin(reservationDto.getDateFin());
			} else {
				throw new ReservationDateInvalideException("Vous ne pouvez réservé que du 01/06 au 15/09");
			}

            return reservationDao.save(reservationAModifier);
        }
        else {
            return createReservation(reservationDto);
        }
	}


	@Override
	public Reservation createReservation(ReservationDto reservation) {
		reservation.setMontantAReglerEnEuro(reservation.getMontantAReglerEnEuro() * (1 - reservation.getClient().getLienDeParente().getCoefficient()));

		if (reservation.getDateDebut().isAfter(LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 1)) &&
		reservation.getDateDebut().isBefore(LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15)) &&
		reservation.getDateFin().isAfter(LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 1)) &&
		reservation.getDateFin().isBefore(LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15))
		) {
			return reservationDao.save(reservationMapper.toEntity(reservation));
		}
		throw new ReservationDateInvalideException("Vous ne pouvez réservé que du 01/06 au 15/09");
	}

	@Override
	public boolean deleteReservation(Long id) {
		Reservation reservation = getReservation(id);
		if(reservation != null) {
			reservationDao.deleteById(id);
			return true;
		}
		return false;
	}

}
