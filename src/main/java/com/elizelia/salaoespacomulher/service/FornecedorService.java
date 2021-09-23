package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.Fornecedor;
import com.elizelia.salaoespacomulher.repositories.FornecedorRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository repository;
	
	public Fornecedor findById(Long idFornecedor) {
		Optional<Fornecedor> obj = repository.findById(idFornecedor);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idFornecedor + ". Tipo: " + Fornecedor.class.getName()));
	}
	public List<Fornecedor> findAll() {
		return repository.findAll();
	}
	public Fornecedor update(Long idFornecedor, Fornecedor obj) {
		Fornecedor newObj = findById(idFornecedor);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Fornecedor newObj, Fornecedor obj) {
		newObj.setNomeFornecedor(obj.getNomeFornecedor());
		newObj.setTelefoneFornecedor(obj.getTelefoneFornecedor());
		newObj.setIdFornecedor(obj.getIdFornecedor());
		newObj.setObsevacaoFornecedor(obj.getObsevacaoFornecedor());
	}
	
	public Fornecedor create(Fornecedor obj) {
		obj.setIdFornecedor(null);
		return repository.save(obj);
	}
	public void delete(Long idFornecedor) {
		Fornecedor obj = findById(idFornecedor);
		repository.delete(obj);	
	}
}
