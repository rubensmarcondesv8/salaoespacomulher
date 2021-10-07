package com.elizelia.salaoespacomulher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.ContaCorrente;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long>{
	@Query("SELECT obj FROM ContaCorrente obj WHERE obj.numeroContaCorrente = :numero")
	ContaCorrente findByNumeroContaCorrente(@Param(value = "numero") String numero);
	//implementar os extratos

}
