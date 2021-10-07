package com.elizelia.salaoespacomulher.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.ContaCorrente;
import com.elizelia.salaoespacomulher.domain.Lancamento;
import com.elizelia.salaoespacomulher.domain.enums.TipoLancamento;
import com.elizelia.salaoespacomulher.repositories.LancamentoRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class LancamentoService {
	@Autowired
	private LancamentoRepository repository;
	@Autowired
	private ContaCorrenteService contaCorrenteService;
	
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
		newObj.setDataHoraLancamento(new GregorianCalendar(TimeZone.getTimeZone("GMT-3"),new Locale("pt_BR")));
		newObj.setDescrLancamento(obj.getDescrLancamento());
		ContaCorrente conta = contaCorrenteService.findById(newObj.getContaCorrente().getIdContaCorrente());
		if(obj.getTipoLancamento() == TipoLancamento.D) {
			conta.setSaldoContaCorrente(conta.getSaldoContaCorrente().add(newObj.getValorLancamento()));
			conta.setSaldoContaCorrente(conta.getSaldoContaCorrente().subtract(obj.getValorLancamento()));
		}else {			
			conta.setSaldoContaCorrente(conta.getSaldoContaCorrente().subtract(newObj.getValorLancamento()));
			conta.setSaldoContaCorrente(conta.getSaldoContaCorrente().add(obj.getValorLancamento()));
		}
		List<Lancamento> lista = new ArrayList<>();
		lista = conta.getExtratoContaCorrente();
		lista.remove(obj);
		lista.add(obj);
		conta.setExtratoContaCorrente(lista);
		contaCorrenteService.update(newObj.getContaCorrente().getIdContaCorrente(), conta);
		newObj.setValorLancamento(obj.getValorLancamento());
	}
	
	public Lancamento create( Long idContaCorrente, Lancamento obj) {
		obj.setIdLancamento(null);
		ContaCorrente conta = contaCorrenteService.findById(idContaCorrente);
		if(obj.getTipoLancamento() == TipoLancamento.D) {
			conta.setSaldoContaCorrente(conta.getSaldoContaCorrente().subtract(obj.getValorLancamento()));
		}else {
			conta.setSaldoContaCorrente(conta.getSaldoContaCorrente().add(obj.getValorLancamento()));
		}
		List<Lancamento> lista = new ArrayList<>();
		lista = conta.getExtratoContaCorrente();
		lista.add(obj);
		conta.setExtratoContaCorrente(lista);
		contaCorrenteService.update(idContaCorrente, conta);
		obj.setContaCorrente(conta);
		return repository.save(obj);
	}
	public void delete(Long idLancamento) {
		Lancamento obj = findById(idLancamento);
		ContaCorrente conta = contaCorrenteService.findById(obj.getContaCorrente().getIdContaCorrente());
		if(obj.getTipoLancamento() == TipoLancamento.D) {
			conta.setSaldoContaCorrente(conta.getSaldoContaCorrente().add(obj.getValorLancamento()));
		}else {
			conta.setSaldoContaCorrente(conta.getSaldoContaCorrente().subtract(obj.getValorLancamento()));
		}
		List<Lancamento> lista = new ArrayList<>();
		lista = conta.getExtratoContaCorrente();
		lista.remove(obj);
		conta.setExtratoContaCorrente(lista);
		contaCorrenteService.update(obj.getContaCorrente().getIdContaCorrente(), conta);
		repository.delete(obj);	
	}

}
