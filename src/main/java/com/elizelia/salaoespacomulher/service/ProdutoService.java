package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.Produto;
import com.elizelia.salaoespacomulher.repositories.ProdutoRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	public Produto findById(Long idProduto) {
		Optional<Produto> obj = repository.findById(idProduto);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idProduto + ". Tipo: " + Produto.class.getName()));
	}
	public List<Produto> findAll() {
		return repository.findAll();
	}
	public Produto update(Long idProduto, Produto obj) {
		Produto newObj = findById(idProduto);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Produto newObj, Produto obj) {
		newObj.setDescProduto(obj.getDescProduto());
		newObj.setNomeProduto(obj.getNomeProduto());
		newObj.setPrecoUnitario(obj.getPrecoUnitario());
		newObj.setComissaoProduto(obj.getComissaoProduto());
		newObj.setCategoriaProduto(obj.getCategoriaProduto());
		newObj.setQuantidadeEstoque(obj.getQuantidadeEstoque());
		
	}
	public Produto create(Produto obj) {
		obj.setIdProduto(null);
		return repository.save(obj);
	}
	
	public void delete(Long idProduto) {
		Produto obj = findById(idProduto);
		repository.delete(obj);	
	}

}
