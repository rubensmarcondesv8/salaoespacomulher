package com.elizelia.salaoespacomulher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.CatProfissional;

@Repository
public interface CatProfissionalRepository extends JpaRepository<CatProfissional, String>{

}
