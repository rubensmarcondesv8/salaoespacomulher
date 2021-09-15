package com.elizelia.salaoespacomulher.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.elizelia.salaoespacomulher.domain.CatProfissional;
import com.elizelia.salaoespacomulher.dtos.CatProfissionalDTO;
import com.elizelia.salaoespacomulher.service.CatProfissionalService;

@RestController
@RequestMapping(value = "/catprofissional")
public class CatProfissionalResource {
	@Autowired
	private CatProfissionalService service;
	
	@GetMapping(value = "/{idCatProfissional}")
	public ResponseEntity<CatProfissional> findById(@PathVariable long idCatProfissional){
		CatProfissional obj = service.findById(idCatProfissional);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CatProfissionalDTO>> findAll(){
		List<CatProfissional> list = service.findAll();
		List<CatProfissionalDTO> listDTO = list.stream().map(obj -> new CatProfissionalDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<CatProfissional> create(@RequestBody CatProfissional obj){
		CatProfissional newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("catprofissional/{idCatProfissional}").buildAndExpand(newObj.getIdCatProfissional()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{idCatProfissional}")
	public ResponseEntity<CatProfissional> update(@PathVariable Long idCatProfissional, @RequestBody CatProfissional obj){
		CatProfissional newObj = service.update(idCatProfissional, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{idCatProfissional}")
	public ResponseEntity<Void> delete(@PathVariable Long idCatProfissional){
		service.delete(idCatProfissional);
		return ResponseEntity.noContent().build();
	}

}
