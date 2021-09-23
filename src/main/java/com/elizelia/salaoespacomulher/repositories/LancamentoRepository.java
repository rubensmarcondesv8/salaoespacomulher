package com.elizelia.salaoespacomulher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	@Query("SELECT obj FROM Lancamento obj WHERE obj.contaCorrente.idContaCorrente = :idContaCorrente ORDER BY idLancamento")
	List<Lancamento> findAllByContaCorrente(@Param(value = "idContaCorrente") Long idContaCorrente);
}
