package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.Servico;
import com.elizelia.salaoespacomulher.repositories.ServicoRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {
	@Autowired
	private ServicoRepository repository;
	
	public Servico findById(Long idServico) {
		Optional<Servico> obj = repository.findById(idServico);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idServico + ". Tipo: " + Servico.class.getName()));
	}
	public List<Servico> findAll() {
		return repository.findAll();
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
		newObj.setComissaoSalao(obj.getComissaoSalao());
		newObj.setCategoriaServico(obj.getCategoriaServico());		
	}
	
	public Servico create(Servico obj) {
		obj.setIdServico(null);
		return repository.save(obj);
	}
	public void delete(Long idServico) {
		Servico obj = findById(idServico);
		repository.delete(obj);	
	}
	
	public Servico updatePatch(Long idServico, Servico obj) {
		Servico newObj = findById(idServico);
		updatePatchData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updatePatchData(Servico newObj, Servico obj) {
		if(obj.getDescrServico() != null) {
			newObj.setDescrServico(obj.getDescrServico());
		}
		if(obj.getNomeServico() != null) {
			newObj.setNomeServico(obj.getNomeServico());
		}
		if(obj.getPrecoBaseServico() != null) {
			newObj.setPrecoBaseServico(obj.getPrecoBaseServico());
		}
		if(obj.getComissaoSalao() != null) {
			newObj.setComissaoSalao(obj.getComissaoSalao());
		}
	}

}
