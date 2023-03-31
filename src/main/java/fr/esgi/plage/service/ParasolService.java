package fr.esgi.plage.service;

import java.util.List;

import fr.esgi.plage.business.Parasol;

public interface ParasolService {
	
	Parasol getParasol(Long id);

	List<Parasol> getAllParasolReserved();

	List<Parasol> getAllFreeParasol();
}
