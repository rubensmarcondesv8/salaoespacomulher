package com.elizelia.salaoespacomulher.config;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//import com.elizelia.salaoespacomulher.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	//@Autowired
	//private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String estrategia;
	
	@Bean
	public boolean instanciaBaseDeDados() {
		if(estrategia.equals("create-drop")) {
			//this.dbService.instanciaBaseDeDados();
		}
		return false;
	}
}
