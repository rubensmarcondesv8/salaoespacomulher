package com.elizelia.salaoespacomulher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elizelia.salaoespacomulher.domain.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
	@Query("SELECT obj0 FROM Profissional obj0, CatProfissional obj1 WHERE obj1.idCatProfissional = :idCatProfissional ORDER BY obj0.nomeProfissional")
	List<Profissional> findAllByCatProfissional(@Param(value = "idCatProfissional") Long idCatProfissional);

}
