package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatProduto;
import com.elizelia.salaoespacomulher.dtos.CatProdutoDTO;
import com.elizelia.salaoespacomulher.repositories.CatProdutoRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class CatProdutoService {
	
	@Autowired
	private CatProdutoRepository repository;
	
	public CatProduto findById(String nomeCatProduto) {
		Optional<CatProduto> obj = repository.findById(nomeCatProduto);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + nomeCatProduto + ", Tipo: " + CatProduto.class.getName()));
	}
	
	public List<CatProduto> findAll() {
		return repository.findAll();
	}

	public CatProduto create(CatProduto obj) {
		// obj.setNomeCatProduto(null); na proximas entidades onde o id é gerado pelo
		// banco deve descomentar essa linha
		return repository.save(obj);
	}

	public CatProduto update(String nomeCatProduto, CatProdutoDTO objDTO) {
		CatProduto obj = findById(nomeCatProduto);
		// obj.setNomeCatProduto(objDTO.getNomeCatProduto()); para outras classes pode
		// ser necessáio descomentar essa linha
		obj.setDescCatProduto(objDTO.getDescCatProduto());
		return repository.save(obj);
	}

	public void delete(String nomeCatProduto) {
		findById(nomeCatProduto);
		try {
			repository.deleteById(nomeCatProduto);
		} catch (DataIntegrityViolationException e) {
			throw new com.elizelia.salaoespacomulher.service.exceptions.DataIntegrityViolationException(
					"Categoria não pode ser deletada. Possui Serviços associados.");
		}
	}

}
