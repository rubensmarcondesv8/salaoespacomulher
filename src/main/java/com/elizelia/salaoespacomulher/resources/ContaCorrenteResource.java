package com.elizelia.salaoespacomulher.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elizelia.salaoespacomulher.domain.ContaCorrente;
import com.elizelia.salaoespacomulher.service.ContaCorrenteService;

@RestController
@RequestMapping(value="/contacorrente")
@CrossOrigin("*")
public class ContaCorrenteResource {
	@Autowired
	private ContaCorrenteService service;
	
	@GetMapping(value = "/{idContaCorrente}")
	public ResponseEntity<ContaCorrente> findById(@PathVariable Long idContaCorrente){
		ContaCorrente obj = service.findById(idContaCorrente);
		return ResponseEntity.ok().body(obj);
	}

}
