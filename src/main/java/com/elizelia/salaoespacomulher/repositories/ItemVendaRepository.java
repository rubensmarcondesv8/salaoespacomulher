package com.elizelia.salaoespacomulher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.ItemVenda;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long>{
	@Query("SELECT obj FROM ItemVenda obj WHERE obj.Venda.idVenda = :idVenda ORDER BY idItem")
	List<ItemVenda> findAllByIdVenda(@Param(value = "idVenda") Long idVenda);
	
}
