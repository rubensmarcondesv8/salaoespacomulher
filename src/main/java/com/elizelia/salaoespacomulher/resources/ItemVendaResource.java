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

import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.dtos.ItemVendaDTO;
import com.elizelia.salaoespacomulher.service.ItemVendaService;

@RestController
@RequestMapping(value = "/itemvenda")
public class ItemVendaResource {
	@Autowired
	private ItemVendaService service;

	@GetMapping(value = "/{idItem}")
	public ResponseEntity<ItemVenda> findById(@PathVariable Long idItem) {
		ItemVenda obj = service.findById(idItem);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<ItemVendaDTO>> findAll(
			@RequestParam(value = "idVenda", defaultValue = "0") Long idVenda) {
		List<ItemVenda> list = service.findAll(idVenda);
		List<ItemVendaDTO> listDTO = list.stream().map(obj -> new ItemVendaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{idItem}")
	public ResponseEntity<ItemVenda> update(@PathVariable Long idItem, @Valid @RequestBody ItemVenda obj) {
		ItemVenda newObj = service.update(idItem, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{idItem}")
	public ResponseEntity<ItemVenda> updatePatch(@PathVariable Long idItem, @Valid @RequestBody ItemVenda obj) {
		ItemVenda newObj = service.update(idItem, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<ItemVenda> create(@RequestParam(value = "Venda", defaultValue = "0") Long idVenda,
			@Valid @RequestBody ItemVenda obj) {
		ItemVenda newObj = service.create(idVenda, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/itemvenda/{idItem}")
				.buildAndExpand(newObj.getIdItem()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{idItem}")
	public ResponseEntity<Void> delete(@PathVariable Long idItem){
		service.delete(idItem);
		return ResponseEntity.noContent().build();
	}
}
