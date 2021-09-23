package com.elizelia.salaoespacomulher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.CatLancamento;

@Repository
public interface CatLancamentoRepository extends JpaRepository<CatLancamento, Long>{

}
