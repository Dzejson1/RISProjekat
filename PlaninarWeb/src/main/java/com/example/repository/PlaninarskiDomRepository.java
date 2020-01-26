package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Planina56417;
import model.Planinarskidom56417;

public interface PlaninarskiDomRepository extends JpaRepository<Planinarskidom56417, Integer>{

	List<Planinarskidom56417> findByPlanina56417(Planina56417 plan);

}
