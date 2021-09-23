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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.elizelia.salaoespacomulher.domain.ContaCorrente;
import com.elizelia.salaoespacomulher.dtos.ContaCorrenteDTO;
import com.elizelia.salaoespacomulher.service.ContaCorrenteService;

@RestController
@RequestMapping(value="/contacorrente")
@CrossOrigin("*")
public class ContaCorrenteResource {
	@Autowired
	private ContaCorrenteService service;
	
	@GetMapping(value = "/{idContaCorrente}")
	public ResponseEntity<ContaCorrente> findById(@PathVariable Long idContaCorrente){
		ContaCorrente obj = service.findById(idContaCorrente);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<ContaCorrenteDTO>> findAll() {
		List<ContaCorrente> list = service.findAll();
		List<ContaCorrenteDTO> listDTO = list.stream().map(obj -> new ContaCorrenteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PutMapping(value = "/{idContaCorrente}")
	public ResponseEntity<ContaCorrente> update(@PathVariable Long idContaCorrente, @Valid @RequestBody ContaCorrente obj) {
		ContaCorrente newObj = service.update(idContaCorrente, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{idContaCorrente}")
	public ResponseEntity<ContaCorrente> updatePatch(@PathVariable Long idContaCorrente, @Valid @RequestBody ContaCorrente obj) {
		ContaCorrente newObj = service.update(idContaCorrente, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<ContaCorrente> create(@Valid @RequestBody ContaCorrente obj) {
		ContaCorrente newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/contacorrente/{idContaCorrente}")
				.buildAndExpand(newObj.getIdContaCorrente()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{ContaCorrente}")
	public ResponseEntity<Void> delete(@PathVariable Long idContaCorrente){
		service.delete(idContaCorrente);
		return ResponseEntity.noContent().build();
	}
}
