package com.elizelia.salaoespacomulher.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.ContaCorrente;
import com.elizelia.salaoespacomulher.domain.Profissional;
import com.elizelia.salaoespacomulher.repositories.ContaCorrenteRepository;
import com.elizelia.salaoespacomulher.repositories.ProfissionalRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ProfissionalService {
	@Autowired
	private ProfissionalRepository repository;
	@Autowired
	private ContaCorrenteRepository contaRepository;
	
	public Profissional findById(Long idProfissional) {
		Optional<Profissional> obj = repository.findById(idProfissional);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idProfissional + ". Tipo: " + Profissional.class.getName()));
	}
	public List<Profissional> findAll() {
		return repository.findAll();
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
		newObj.setDataNascProfissional(obj.getDataNascProfissional());
		newObj.setCategoriaPrincipal(obj.getCategoriaPrincipal());
		newObj.setCategoriaAdicional(obj.getCategoriaAdicional());
		
	}
	public Profissional create(Profissional obj) {
		obj.setIdProfissional(null);
		ContaCorrente conta = new ContaCorrente();
		conta.setIdContaCorrente(null);
		conta.setNumeroContaCorrente(obj.getNumeroCPF());
		conta.setSaldoContaCorrente(new BigDecimal(0));
		obj.setContacorrente(conta);
		contaRepository.save(conta);
		return repository.save(obj);
	}
	public void delete(Long idProfissional) {
		Profissional obj = findById(idProfissional);
		repository.delete(obj);	
	}
}
