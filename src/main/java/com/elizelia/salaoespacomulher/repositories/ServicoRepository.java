package com.elizelia.salaoespacomulher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
