package fr.esgi.plage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.esgi.plage.business.Client;
import fr.esgi.plage.dao.ClientDao;
import fr.esgi.plage.dto.ClientDto;
import fr.esgi.plage.exception.ClientInexistantException;
import fr.esgi.plage.mapper.ClientMapper;
import fr.esgi.plage.service.ClientService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{

	private ClientDao clientDao;
	private ClientMapper clientMapper;

	@Override
	public List<Client> getAllClients() {
		return clientDao.findAll();
	}

	@Override
	public Client getClient(Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	public Client modifyClient(ClientDto clientDto) {
		if (clientDto.getId()==null) {
            throw new ClientInexistantException("Il manque l'id du client");
        }
	  Client clientAModifier = clientDao.findById(clientDto.getId()).orElseThrow(() -> new ClientInexistantException("Ce client n'existe pas"));
	  clientAModifier.setNom(clientDto.getNom());
	  clientAModifier.setPrenom(clientDto.getPrenom());
	  clientAModifier.setEmail(clientDto.getEmail());
	  clientAModifier.setMdp(clientDto.getMdp());
	  clientAModifier.setPays(clientDto.getPays());
	  clientAModifier.setLienDeParente(clientDto.getLienDeParente());
		if (clientDto.getId().equals(clientAModifier.getId())) {
            return clientDao.save(clientAModifier);
        }
        else {
            return createClient(clientDto);
        }
	}

	@Override
	public Client createClient(ClientDto clientDto) {
		if (clientDao.findByNom(clientDto.getNom()) == null) {
			return clientDao.save(clientMapper.toEntity(clientDto));
		}
		else {
			throw new ClientInexistantException("Ce client est déjà présent");
		}

	}

	@Override
	public boolean deleteClient(Long id) {
		Client client = getClient(id);
		if(client != null) {
			clientDao.deleteById(id);
			return true;
		}
		return false;
	}

}
