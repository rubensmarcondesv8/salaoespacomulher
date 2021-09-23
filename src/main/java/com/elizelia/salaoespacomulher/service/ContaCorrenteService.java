package com.elizelia.salaoespacomulher.service;

import java.util.List;
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

	public List<ContaCorrente> findAll() {
		return repository.findAll();
	}

	public ContaCorrente update(Long idContaCorrente, ContaCorrente obj) {
		ContaCorrente newObj = findById(idContaCorrente);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(ContaCorrente newObj, ContaCorrente obj) {
		newObj.setExtratoContaCorrente(obj.getExtratoContaCorrente());
		newObj.setIdContaCorrente(obj.getIdContaCorrente());
		newObj.setNumeroContaCorrente(obj.getNumeroContaCorrente());
		newObj.setProfissional(obj.getProfissional());
		newObj.setSaldoContaCorrente(obj.getSaldoContaCorrente());
	}

	public ContaCorrente create(ContaCorrente obj) {
		obj.setIdContaCorrente(null);
		return repository.save(obj);
	}

	public void delete(Long idContaCorrente) {
		ContaCorrente obj = findById(idContaCorrente);
		repository.delete(obj);	
	}

}
