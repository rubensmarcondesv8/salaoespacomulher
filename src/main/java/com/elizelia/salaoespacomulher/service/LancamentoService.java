package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatLancamento;
import com.elizelia.salaoespacomulher.domain.ContaCorrente;
import com.elizelia.salaoespacomulher.domain.Lancamento;
import com.elizelia.salaoespacomulher.repositories.LancamentoRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class LancamentoService {
	@Autowired
	private LancamentoRepository repository;
	@Autowired
	private ContaCorrenteService contaCorrenteService;
	@Autowired
	private CatLancamentoService catLancamentoService;
	
	public Lancamento findById(Long idLancamento) {
		Optional<Lancamento> obj = repository.findById(idLancamento);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idLancamento + ". Tipo: " + Lancamento.class.getName()));
	}
	public List<Lancamento> findAll(Long idContaCorrente) {
		contaCorrenteService.findById(idContaCorrente);
		return repository.findAllByContaCorrente(idContaCorrente);
	}
	public Lancamento update(Long idLancamento, Lancamento obj) {
		Lancamento newObj = findById(idLancamento);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Lancamento newObj, Lancamento obj) {
		
		
	}
	public Lancamento create(Long idCatLancamento, Long idContaCorrente, Lancamento obj) {
		obj.setIdLancamento(null);
		CatLancamento cat = catLancamentoService.findById(idCatLancamento);
		ContaCorrente conta = contaCorrenteService.findById(idContaCorrente);
		obj.setCatLancamento(cat);
		obj.setContaCorrente(conta);
		return repository.save(obj);
	}
	public void delete(Long idLancamento) {
		Lancamento obj = findById(idLancamento);
		repository.delete(obj);	
	}

}
