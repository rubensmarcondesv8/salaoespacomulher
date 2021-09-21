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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.elizelia.salaoespacomulher.domain.CatServico;
import com.elizelia.salaoespacomulher.dtos.CatServicoDTO;
import com.elizelia.salaoespacomulher.service.CatServicoService;

@RestController
@RequestMapping(value = "/catservico")
public class CatServicoResource {
	@Autowired
	private CatServicoService service;
	
	@GetMapping(value = "/{nomeCatServico}")
	public ResponseEntity<CatServico> findById(@PathVariable String nomeCatServico){
		CatServico obj = service.findById(nomeCatServico);
		
		return ResponseEntity.ok().body(obj);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public ResponseEntity<List<CatServicoDTO>> findAll(){
		List<CatServico> list = service.findAll();
		List<CatServicoDTO> listDTO = list.stream().map(obj -> new CatServicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<CatServico> create(@Valid @RequestBody CatServico obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nomeCatServico}").buildAndExpand(obj.getNomeCatServico()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{nomeCatServico}")
	public ResponseEntity<CatServicoDTO> update(@PathVariable String nomeCatServico, @Valid @RequestBody CatServicoDTO objDTO ){
		CatServico newObj = service.update(nomeCatServico, objDTO);
		return ResponseEntity.ok().body(new CatServicoDTO(newObj));
	}
	
	@DeleteMapping(value = "/{nomeCatServico}")
	public ResponseEntity<Void> delete(@PathVariable String nomeCatServico){
		service.delete(nomeCatServico);
		return ResponseEntity.noContent().build();
	}
}