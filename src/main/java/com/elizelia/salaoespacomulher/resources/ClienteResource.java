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

import com.elizelia.salaoespacomulher.domain.Cliente;
import com.elizelia.salaoespacomulher.dtos.ClienteDTO;
import com.elizelia.salaoespacomulher.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{idCliente}")
	public ResponseEntity<Cliente> findById(@PathVariable Long idCliente) {
		Cliente obj = service.findById(idCliente);
		return ResponseEntity.ok().body(obj);
	}
	@CrossOrigin("*")
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{idCliente}")
	public ResponseEntity<Cliente> update(@PathVariable Long idCliente, @Valid @RequestBody Cliente obj) {
		Cliente newObj = service.update(idCliente, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{idCliente}")
	public ResponseEntity<Cliente> updatePatch(@PathVariable Long idCliente, @Valid @RequestBody Cliente obj) {
		Cliente newObj = service.update(idCliente, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Cliente> create(@RequestParam(value = "catCliente", defaultValue = "0") Long idCatCliente,
			@Valid @RequestBody Cliente obj) {
		Cliente newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/profissional/{idCliente}")
				.buildAndExpand(newObj.getIdCliente()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{idCliente}")
	public ResponseEntity<Void> delete(@PathVariable Long idCliente){
		service.delete(idCliente);
		return ResponseEntity.noContent().build();
	}

}
