package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.Cliente;
import com.elizelia.salaoespacomulher.repositories.ClienteRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Long idCliente) {
		Optional<Cliente> obj = repository.findById(idCliente);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idCliente + ". Tipo: " + Cliente.class.getName()));
	}
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	public Cliente update(Long idCliente, Cliente obj) {
		Cliente newObj = findById(idCliente);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNomeCliente(obj.getNomeCliente());
		newObj.setTelefoneCliente(obj.getTelefoneCliente());
		newObj.setAniversarioCliente(obj.getAniversarioCliente());
	}
	
	public Cliente create(Cliente obj) {
		obj.setIdCliente(null);
		return repository.save(obj);
	}
	public void delete(Long idCliente) {
		Cliente obj = findById(idCliente);
		repository.delete(obj);	
	}
}
