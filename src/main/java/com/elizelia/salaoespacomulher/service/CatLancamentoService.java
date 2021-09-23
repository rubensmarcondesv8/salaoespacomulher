package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatLancamento;
import com.elizelia.salaoespacomulher.repositories.CatLancamentoRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class CatLancamentoService {
	@Autowired
	private CatLancamentoRepository repository;
	
	public CatLancamento findById(Long idCatLancamento) {
		Optional<CatLancamento> obj = repository.findById(idCatLancamento);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idCatLancamento + ". Tipo: " + CatLancamento.class.getName()));
	}
	
	public List<CatLancamento> findAll(){
		return repository.findAll();
	}
	
	public CatLancamento create(CatLancamento obj) {
		obj.setIdCatLancamento(null);
		return repository.save(obj);
	}
	
	public CatLancamento update(Long idCatLancamento, CatLancamento obj) {
		CatLancamento newObj = findById(idCatLancamento);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void updateData(CatLancamento newObj, CatLancamento obj) {
		newObj.setDescrLancamento(obj.getDescrLancamento());
		newObj.setIdCatLancamento(obj.getIdCatLancamento());
		newObj.setTipoLancamento(obj.getTipoLancamento());
	}
	
	public void delete(Long idCatLancamento) {
		CatLancamento obj = findById(idCatLancamento);
		repository.delete(obj);
	}
}
