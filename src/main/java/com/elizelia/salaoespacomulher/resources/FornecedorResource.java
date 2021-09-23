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

import com.elizelia.salaoespacomulher.domain.Fornecedor;
import com.elizelia.salaoespacomulher.dtos.FornecedorDTO;
import com.elizelia.salaoespacomulher.service.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedor")
@CrossOrigin("*")
public class FornecedorResource {
	@Autowired
	private FornecedorService service;
	
	@GetMapping(value = "/{idFornecedor}")
	public ResponseEntity<Fornecedor> findById(@PathVariable Long idFornecedor) {
		Fornecedor obj = service.findById(idFornecedor);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<FornecedorDTO>> findAll() {
		List<Fornecedor> list = service.findAll();
		List<FornecedorDTO> listDTO = list.stream().map(obj -> new FornecedorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{idFornecedor}")
	public ResponseEntity<Fornecedor> update(@PathVariable Long idFornecedor, @Valid @RequestBody Fornecedor obj) {
		Fornecedor newObj = service.update(idFornecedor, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{idFornecedor}")
	public ResponseEntity<Fornecedor> updatePatch(@PathVariable Long idFornecedor, @Valid @RequestBody Fornecedor obj) {
		Fornecedor newObj = service.update(idFornecedor, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Fornecedor> create(@RequestParam(value = "catFornecedor", defaultValue = "0") Long idCatFornecedor,
			@Valid @RequestBody Fornecedor obj) {
		Fornecedor newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/fornecedor/{idFornecedor}")
				.buildAndExpand(newObj.getIdFornecedor()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{idFornecedor}")
	public ResponseEntity<Void> delete(@PathVariable Long idFornecedor){
		service.delete(idFornecedor);
		return ResponseEntity.noContent().build();
	}
}
