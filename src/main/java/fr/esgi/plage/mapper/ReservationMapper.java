package fr.esgi.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.esgi.plage.business.Reservation;
import fr.esgi.plage.dto.ReservationDto;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

	ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);
	
	ReservationDto toDto(Reservation reservation);
	
	Reservation toEntity(ReservationDto reservationDto);
}
