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

import com.elizelia.salaoespacomulher.domain.Servico;
import com.elizelia.salaoespacomulher.dtos.ServicoDTO;
import com.elizelia.salaoespacomulher.service.ServicoService;

@RestController
@RequestMapping(value = "/servico")
public class ServicoResource {
	@Autowired
	private ServicoService service;

	@GetMapping(value = "/{idServico}")
	public ResponseEntity<Servico> findById(@PathVariable Long idServico) {
		Servico obj = service.findById(idServico);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<ServicoDTO>> findAll(
			@RequestParam(value = "catServico", defaultValue = "0") String nomeCatServico) {
		List<Servico> list = service.findAll(nomeCatServico);
		List<ServicoDTO> listDTO = list.stream().map(obj -> new ServicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{idServico}")
	public ResponseEntity<Servico> update(@PathVariable Long idServico, @RequestBody Servico obj) {
		Servico newObj = service.update(idServico, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{idServico}")
	public ResponseEntity<Servico> updatePatch(@PathVariable Long idServico, @RequestBody Servico obj) {
		Servico newObj = service.update(idServico, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Servico> create(@RequestParam(value = "catServico", defaultValue = "0") String nomeCatServico,
			@RequestBody Servico obj) {
		Servico newObj = service.create(nomeCatServico, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/servico/{idServico}")
				.buildAndExpand(newObj.getIdServico()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{idServico}")
	public ResponseEntity<Void> delete(@PathVariable Long idServico){
		service.delete(idServico);
		return ResponseEntity.noContent().build();
	}

}
