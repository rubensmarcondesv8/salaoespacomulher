package com.elizelia.salaoespacomulher.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.elizelia.salaoespacomulher.domain.Profissional;
import com.elizelia.salaoespacomulher.dtos.ProfissionalDTO;
import com.elizelia.salaoespacomulher.service.ProfissionalService;

@RestController
@RequestMapping(value = "/profissional")
public class ProfissionalResource {
	@Autowired
	private ProfissionalService service;
	
	@GetMapping(value = "/{idProfissional}")
	public ResponseEntity<Profissional> findById(@PathVariable Long idProfissional) {
		Profissional obj = service.findById(idProfissional);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<ProfissionalDTO>> findAll(
			@RequestParam(value = "idCatProfissional", defaultValue = "0") Long idCatProfissional) {
		List<Profissional> list = service.findAll(idCatProfissional);
		List<ProfissionalDTO> listDTO = list.stream().map(obj -> new ProfissionalDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{idProfissional}")
	public ResponseEntity<Profissional> update(@PathVariable Long idProfissional, @RequestBody Profissional obj) {
		Profissional newObj = service.update(idProfissional, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{idProfissional}")
	public ResponseEntity<Profissional> updatePatch(@PathVariable Long idProfissional, @RequestBody Profissional obj) {
		Profissional newObj = service.update(idProfissional, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Profissional> create(@RequestParam(value = "catProfissional", defaultValue = "0") Long idCatProfissional,
			@RequestBody Profissional obj) {
		Profissional newObj = service.create(idCatProfissional, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/profissional/{idProfissional}")
				.buildAndExpand(newObj.getIdProfissional()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{idProfissional}")
	public ResponseEntity<Void> delete(@PathVariable Long idProfissional){
		service.delete(idProfissional);
		return ResponseEntity.noContent().build();
	}
}
