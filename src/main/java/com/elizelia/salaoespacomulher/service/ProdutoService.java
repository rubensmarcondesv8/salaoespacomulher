package com.elizelia.salaoespacomulher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatProduto;
import com.elizelia.salaoespacomulher.domain.Produto;
import com.elizelia.salaoespacomulher.repositories.ProdutoRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private CatProdutoService catProdutoService;
	public Produto findById(Long idProduto) {
		Optional<Produto> obj = repository.findById(idProduto);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idProduto + ". Tipo: " + Produto.class.getName()));
	}
	public List<Produto> findAll(String nomeCatProduto) {
		catProdutoService.findById(nomeCatProduto);
		return repository.findAllByCatProduto(nomeCatProduto);
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
		
	}
	public Produto create(String nomeCatProduto, Produto obj) {
		obj.setIdProduto(null);
		CatProduto cat = catProdutoService.findById(nomeCatProduto);
		obj.setCatProduto(cat);
		return repository.save(obj);
	}
	public void delete(Long idProduto) {
		Produto obj = findById(idProduto);
		repository.delete(obj);	
	}

}
