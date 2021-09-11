package com.elizelia.salaoespacomulher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.CatProduto;

@Repository
public interface CatProdutoRepository extends JpaRepository<CatProduto, String>{

}
