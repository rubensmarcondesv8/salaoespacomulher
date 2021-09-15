package com.elizelia.salaoespacomulher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	@Query("SELECT obj FROM Produto obj WHERE obj.catProduto.nomeCatProduto = :nomeCatProduto ORDER BY nomeProduto")
	List<Produto> findAllByCatProduto(@Param(value = "nomeCatProduto") String nomeCatServico);

}
