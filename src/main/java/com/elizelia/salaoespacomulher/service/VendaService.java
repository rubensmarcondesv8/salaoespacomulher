package com.elizelia.salaoespacomulher.service;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.Venda;
import com.elizelia.salaoespacomulher.repositories.VendaRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class VendaService {
	@Autowired
	private VendaRepository repository;
	
	public Venda findById(Long idVenda) {
		Optional<Venda> obj = repository.findById(idVenda);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idVenda + ". Tipo: " + Venda.class.getName()));
	}
	
	public List<Venda> findAll(){
		return repository.findAll();
	}
	
	public Venda create(Venda obj) {
		obj.setIdVenda(null);
		return repository.save(obj);
	}
	
	public Venda update(Long idVenda, Venda obj) {
		Venda newObj = findById(idVenda);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void updateData(Venda newObj, Venda obj) {
		newObj.setDataHoraPagamentoVenda(new GregorianCalendar(TimeZone.getTimeZone("GMT-3"),new Locale("pt_BR")));
		newObj.setStatusVenda(obj.getStatusVenda());
	}
	
	public void delete(Long idVenda) {
		Venda obj = findById(idVenda);
		repository.delete(obj);
	}

}
