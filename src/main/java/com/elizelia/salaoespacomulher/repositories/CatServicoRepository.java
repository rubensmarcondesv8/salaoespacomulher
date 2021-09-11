package com.elizelia.salaoespacomulher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.CatServico;

@Repository
public interface CatServicoRepository extends JpaRepository<CatServico, String>{

}
