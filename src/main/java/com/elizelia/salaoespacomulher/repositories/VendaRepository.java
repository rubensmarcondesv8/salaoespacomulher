package com.elizelia.salaoespacomulher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{

}
