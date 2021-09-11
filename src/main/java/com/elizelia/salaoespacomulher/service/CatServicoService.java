package com.elizelia.salaoespacomulher.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatServico;
import com.elizelia.salaoespacomulher.repositories.CatServicoRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class CatServicoService {
	@Autowired
	private CatServicoRepository repository;

	public CatServico findById(String nomeCatServico) {
		Optional<CatServico> obj = repository.findById(nomeCatServico);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontra! Id: " + nomeCatServico + ", Tipo: " + CatServico.class.getName()));

	}
}
