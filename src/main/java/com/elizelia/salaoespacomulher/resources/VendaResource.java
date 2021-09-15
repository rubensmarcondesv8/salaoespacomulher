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

import com.elizelia.salaoespacomulher.domain.Venda;
import com.elizelia.salaoespacomulher.dtos.VendaDTO;
import com.elizelia.salaoespacomulher.service.VendaService;

@RestController
@RequestMapping(value = "/venda")
public class VendaResource {
	@Autowired
	private VendaService service;
	
	@GetMapping(value = "/{idVenda}")
	public ResponseEntity<Venda> findById(@PathVariable long idVenda){
		Venda obj = service.findById(idVenda);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<VendaDTO>> findAll(){
		List<Venda> list = service.findAll();
		List<VendaDTO> listDTO = list.stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Venda> create(@RequestBody Venda obj){
		Venda newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("catprofissional/{idVenda}").buildAndExpand(newObj.getIdVenda()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{idVenda}")
	public ResponseEntity<Venda> update(@PathVariable Long idVenda, @RequestBody Venda obj){
		Venda newObj = service.update(idVenda, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{idVenda}")
	public ResponseEntity<Void> delete(@PathVariable Long idVenda){
		service.delete(idVenda);
		return ResponseEntity.noContent().build();
	}
}
