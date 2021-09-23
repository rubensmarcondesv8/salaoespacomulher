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

import com.elizelia.salaoespacomulher.domain.CatLancamento;
import com.elizelia.salaoespacomulher.dtos.CatLancamentoDTO;
import com.elizelia.salaoespacomulher.service.CatLancamentoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="catlancamento")
public class CatLancamentoResource {
	@Autowired
	private CatLancamentoService service;
	
	@GetMapping(value = "/{idCatLancamento}")
	public ResponseEntity<CatLancamento> findById(@PathVariable long idCatLancamento){
		CatLancamento obj = service.findById(idCatLancamento);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CatLancamentoDTO>> findAll(){
		List<CatLancamento> list = service.findAll();
		List<CatLancamentoDTO> listDTO = list.stream().map(obj -> new CatLancamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<CatLancamento> create(@Valid @RequestBody CatLancamento obj){
		CatLancamento newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("catlancamento/{idCatLancamento}").buildAndExpand(newObj.getIdCatLancamento()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{idCatLancamento}")
	public ResponseEntity<CatLancamento> update(@PathVariable Long idCatLancamento, @Valid @RequestBody CatLancamento obj){
		CatLancamento newObj = service.update(idCatLancamento, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{idCatLancamento}")
	public ResponseEntity<Void> delete(@PathVariable Long idCatLancamento){
		service.delete(idCatLancamento);
		return ResponseEntity.noContent().build();
	}
}
