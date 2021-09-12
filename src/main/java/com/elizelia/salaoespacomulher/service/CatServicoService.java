package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatServico;
import com.elizelia.salaoespacomulher.dtos.CatServicoDTO;
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

	public List<CatServico> findAll() {
		return repository.findAll();
	}

	public CatServico create(CatServico obj) {
		// obj.setNomeCatServico(null); na proximas entidades onde o id é gerado pelo
		// banco deve descomentar essa linha
		return repository.save(obj);
	}

	public CatServico update(String nomeCatServico, CatServicoDTO objDTO) {
		CatServico obj = findById(nomeCatServico);
		// obj.setNomeCatServico(objDTO.getNomeCatServico()); para outras classes pode
		// ser necessáio descomentar essa linha
		obj.setDescrCatServico(objDTO.getDescrCatServico());
		return repository.save(obj);
	}

	public void delete(String nomeCatServico) {
		findById(nomeCatServico);
		try {
			repository.deleteById(nomeCatServico);
		} catch (DataIntegrityViolationException e) {
			throw new com.elizelia.salaoespacomulher.service.exceptions.DataIntegrityViolationException(
					"Categoria não pode ser deletada. Possui Serviços associados.");
		}
	}

}
