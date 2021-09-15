package com.elizelia.salaoespacomulher.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.elizelia.salaoespacomulher.domain.CatProduto;
import com.elizelia.salaoespacomulher.dtos.CatProdutoDTO;
import com.elizelia.salaoespacomulher.service.CatProdutoService;

@RestController
@RequestMapping(value = "/catproduto")
public class CatProdutoResource {
	@Autowired
	private CatProdutoService service;
	
	@GetMapping(value = "/{nomeCatProduto}")
	public ResponseEntity<CatProduto> findById(@PathVariable String nomeCatProduto){
		CatProduto obj = service.findById(nomeCatProduto);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping
	public ResponseEntity<List<CatProdutoDTO>> findAll(){
		List<CatProduto> list = service.findAll();
		List<CatProdutoDTO> listDTO = list.stream().map(obj -> new CatProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<CatProduto> create(@Valid @RequestBody CatProduto obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nomeCatProduto}").buildAndExpand(obj.getNomeCatProduto()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{nomeCatProduto}")
	public ResponseEntity<CatProdutoDTO> update(@Valid @PathVariable String nomeCatProduto, @RequestBody CatProdutoDTO objDTO ){
		CatProduto newObj = service.update(nomeCatProduto, objDTO);
		return ResponseEntity.ok().body(new CatProdutoDTO(newObj));
	}
	
	@DeleteMapping(value = "/{nomeCatProduto}")
	public ResponseEntity<Void> delete(@PathVariable String nomeCatProduto){
		service.delete(nomeCatProduto);
		return ResponseEntity.noContent().build();
	}

}
