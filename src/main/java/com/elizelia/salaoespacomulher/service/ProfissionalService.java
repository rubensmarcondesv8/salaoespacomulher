package com.elizelia.salaoespacomulher.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatProfissional;
import com.elizelia.salaoespacomulher.domain.Profissional;
import com.elizelia.salaoespacomulher.repositories.ProfissionalRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ProfissionalService {
	@Autowired
	private ProfissionalRepository repository;
	@Autowired
	private CatProfissionalService catProfissionalService;
	
	public Profissional findById(Long idProfissional) {
		Optional<Profissional> obj = repository.findById(idProfissional);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idProfissional + ". Tipo: " + Profissional.class.getName()));
	}
	public List<Profissional> findAll(Long idCatProfissional) {
		catProfissionalService.findById(idCatProfissional);
		return repository.findAllByCatProfissional(idCatProfissional);
	}
	public Profissional update(Long idProfissional, Profissional obj) {
		Profissional newObj = findById(idProfissional);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Profissional newObj, Profissional obj) {
		newObj.setNomeProfissional(obj.getNomeProfissional());
		newObj.setNumeroCPF(obj.getNumeroCPF());
		newObj.setEnderecoCompleto(obj.getEnderecoCompleto());
		
	}
	public Profissional create(Long idCatProfissional, Profissional obj) {
		obj.setIdProfissional(null);
		CatProfissional cat = catProfissionalService.findById(idCatProfissional);
		List<CatProfissional> lista = new ArrayList<>();
		lista.add(cat);
		obj.setCatProfissional(lista);
		return repository.save(obj);
	}
	public void delete(Long idProfissional) {
		Profissional obj = findById(idProfissional);
		repository.delete(obj);	
	}
}
