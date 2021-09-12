package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatServico;
import com.elizelia.salaoespacomulher.domain.Servico;
import com.elizelia.salaoespacomulher.repositories.ServicoRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {
	@Autowired
	private ServicoRepository repository;
	@Autowired
	private CatServicoService catServicoService;
	public Servico findById(Long idServico) {
		Optional<Servico> obj = repository.findById(idServico);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idServico + ". Tipo: " + Servico.class.getName()));
	}
	public List<Servico> findAll(String nomeCatServico) {
		catServicoService.findById(nomeCatServico);
		return repository.findAllbyCatServico(nomeCatServico);
	}
	public Servico update(Long idServico, Servico obj) {
		Servico newObj = findById(idServico);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Servico newObj, Servico obj) {
		newObj.setDescrServico(obj.getDescrServico());
		newObj.setNomeServico(obj.getNomeServico());
		newObj.setPrecoBaseServico(obj.getPrecoBaseServico());
		
	}
	public Servico create(String nomeCatServico, Servico obj) {
		obj.setIdServico(null);
		CatServico cat = catServicoService.findById(nomeCatServico);
		obj.setCatServico(cat);
		return repository.save(obj);
	}
	public void delete(Long idServico) {
		Servico obj = findById(idServico);
		repository.delete(obj);	
	}

}
