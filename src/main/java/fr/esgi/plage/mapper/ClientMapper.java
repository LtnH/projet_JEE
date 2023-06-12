package fr.esgi.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {
	
	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
	
	ClientDto toDto(Client client);
	
	Client toEntity(ClientDto clientDto);
	

}
