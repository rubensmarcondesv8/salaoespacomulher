package com.elizelia.salaoespacomulher.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.elizelia.salaoespacomulher.domain.Lancamento;
import com.elizelia.salaoespacomulher.dtos.LancamentoDTO;
import com.elizelia.salaoespacomulher.service.LancamentoService;

@RestController
@RequestMapping(value = "/lancamento")
public class LancamentoResource {
	@Autowired
	private LancamentoService service;
	
	@GetMapping(value = "/{idLancamento}")
	public ResponseEntity<Lancamento> findById(@PathVariable Long idLancamento) {
		Lancamento obj = service.findById(idLancamento);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<LancamentoDTO>> findAll(
			@RequestParam(value = "idContaCorrente", defaultValue = "0") Long idContaCorrente) {
		List<Lancamento> list = service.findAll(idContaCorrente);
		List<LancamentoDTO> listDTO = list.stream().map(obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{idLancamento}")
	public ResponseEntity<Lancamento> update(@PathVariable Long idLancamento, @Valid @RequestBody Lancamento obj) {
		Lancamento newObj = service.update(idLancamento, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{idLancamento}")
	public ResponseEntity<Lancamento> updatePatch(@PathVariable Long idLancamento, @Valid @RequestBody Lancamento obj) {
		Lancamento newObj = service.update(idLancamento, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Lancamento> create(@RequestParam(value = "catLancamento", defaultValue = "0") Long idCatLancamento, @RequestParam(value="idContaCorrente", defaultValue="0") Long idContaCorrente,
			@Valid @RequestBody Lancamento obj) {
		Lancamento newObj = service.create(idCatLancamento, idContaCorrente, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/lancamento/{idLancamento}/{idContaCorrente")
				.buildAndExpand(newObj.getIdLancamento()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{idLancamento}")
	public ResponseEntity<Void> delete(@PathVariable Long idLancamento){
		service.delete(idLancamento);
		return ResponseEntity.noContent().build();
	}

}
