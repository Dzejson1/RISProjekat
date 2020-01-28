package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import model.Rezervacijasmestaja56417;

public interface RezervacijaSmestajaRepository extends JpaRepository<Rezervacijasmestaja56417, Integer>{


	
	@Query("select i from Rezervacijasmestaja56417 i where i.planinarskidom56417.planina56417.idPlanina like :id")
	List<Rezervacijasmestaja56417> nadjiPlanine(@Param("id")int idPlanina);

}
