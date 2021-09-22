package com.elizelia.salaoespacomulher.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.ContaCorrente;
import com.elizelia.salaoespacomulher.repositories.ContaCorrenteRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ContaCorrenteService {
	@Autowired
	private ContaCorrenteRepository repository;
	
	public ContaCorrente findById(Long idContaCorrente) {
		Optional<ContaCorrente> obj = repository.findById(idContaCorrente);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idContaCorrente + ". Tipo: " + ContaCorrente.class.getName()));
	}

}
