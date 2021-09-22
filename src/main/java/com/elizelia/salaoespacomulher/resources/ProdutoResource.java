package com.elizelia.salaoespacomulher.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.elizelia.salaoespacomulher.domain.Produto;
import com.elizelia.salaoespacomulher.dtos.ProdutoDTO;
import com.elizelia.salaoespacomulher.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
@CrossOrigin("*")
public class ProdutoResource {
	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/{idProduto}")
	public ResponseEntity<Produto> findById(@PathVariable Long idProduto) {
		Produto obj = service.findById(idProduto);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll(
			@RequestParam(value = "catProduto", defaultValue = "0") String nomeCatProduto) {
		List<Produto> list = service.findAll(nomeCatProduto);
		List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{idProduto}")
	public ResponseEntity<Produto> update(@PathVariable Long idProduto, @Valid @RequestBody Produto obj) {
		Produto newObj = service.update(idProduto, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{idProduto}")
	public ResponseEntity<Produto> updatePatch(@PathVariable Long idProduto, @Valid @RequestBody Produto obj) {
		Produto newObj = service.update(idProduto, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Produto> create(@RequestParam(value = "catProduto", defaultValue = "0") String nomeCatProduto,
			@Valid @RequestBody Produto obj) {
		Produto newObj = service.create(nomeCatProduto, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/servico/{idProduto}")
				.buildAndExpand(newObj.getIdProduto()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{idProduto}")
	public ResponseEntity<Void> delete(@PathVariable Long idProduto){
		service.delete(idProduto);
		return ResponseEntity.noContent().build();
	}
}
