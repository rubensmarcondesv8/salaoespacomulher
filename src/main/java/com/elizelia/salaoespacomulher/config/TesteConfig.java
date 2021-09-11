package com.elizelia.salaoespacomulher.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.elizelia.salaoespacomulher.service.DBService;

@Configuration
@Profile("teste")
public class TesteConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public void instaciaBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}
}
