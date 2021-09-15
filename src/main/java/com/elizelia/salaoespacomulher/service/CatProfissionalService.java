package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatProfissional;
import com.elizelia.salaoespacomulher.repositories.CatProfissionalRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class CatProfissionalService {
	@Autowired
	private CatProfissionalRepository repository;
	
	public CatProfissional findById(Long idCatProfissional) {
		Optional<CatProfissional> obj = repository.findById(idCatProfissional);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idCatProfissional + ". Tipo: " + CatProfissional.class.getName()));
	}
	
	public List<CatProfissional> findAll(){
		return repository.findAll();
	}
	
	public CatProfissional create(CatProfissional obj) {
		obj.setIdCatProfissional(null);
		return repository.save(obj);
	}
	
	public CatProfissional update(Long idCatProfissional, CatProfissional obj) {
		CatProfissional newObj = findById(idCatProfissional);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void updateData(CatProfissional newObj, CatProfissional obj) {
		newObj.setNomeCatProfissional(obj.getNomeCatProfissional());
		newObj.setDescCatProfissional(obj.getDescCatProfissional());
		newObj.setComissaoCobradaSalao(obj.getComissaoCobradaSalao());
	}
	
	public void delete(Long idCatProfissional) {
		CatProfissional obj = findById(idCatProfissional);
		repository.delete(obj);
	}
	
}
