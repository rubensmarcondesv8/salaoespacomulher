package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.domain.Venda;
import com.elizelia.salaoespacomulher.repositories.ItemVendaRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ItemVendaService {
	@Autowired
	private ItemVendaRepository repository;
	@Autowired
	private VendaService VendaService;
	
	public ItemVenda findById(Long idItemVenda) {
		Optional<ItemVenda> obj = repository.findById(idItemVenda);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idItemVenda + ". Tipo: " + ItemVenda.class.getName()));
	}
	public List<ItemVenda> findAll(Long idVenda) {
		VendaService.findById(idVenda);
		return repository.findAllByIdVenda(idVenda);
	}
	public ItemVenda update(Long idItemVenda, ItemVenda obj) {
		ItemVenda newObj = findById(idItemVenda);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(ItemVenda newObj, ItemVenda obj) {
		newObj.setItemProduto(obj.getItemProduto());
		newObj.setItemServico(obj.getItemServico());
		newObj.setProfissionalVenda(obj.getProfissionalVenda());
		newObj.setQuantidadeItem(obj.getQuantidadeItem());
		newObj.setValorTotalItem();		
	}
	public ItemVenda create(Long idVenda, ItemVenda obj) {
		obj.setIdItem(null);
		Venda venda = VendaService.findById(idVenda);
		obj.setVenda(venda);
		return repository.save(obj);
	}
	public void delete(Long idItemVenda) {
		ItemVenda obj = findById(idItemVenda);
		repository.delete(obj);	
	}
}
