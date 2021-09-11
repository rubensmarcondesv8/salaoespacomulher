package com.elizelia.salaoespacomulher.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elizelia.salaoespacomulher.domain.CatServico;
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
}