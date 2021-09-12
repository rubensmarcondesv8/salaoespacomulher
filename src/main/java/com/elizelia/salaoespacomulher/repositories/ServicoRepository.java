package com.elizelia.salaoespacomulher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	@Query("SELECT obj FROM Servico obj WHERE obj.catServico.nomeCatServico = :nomeCatServico ORDER BY nomeServico")
	List<Servico> findAllbyCatServico(@Param(value = "nomeCatServico") String nomeCatServico);

}
