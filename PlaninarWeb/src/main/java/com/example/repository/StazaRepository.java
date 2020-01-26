package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Planina56417;
import model.Staza56417;

public interface StazaRepository extends JpaRepository<Staza56417, Integer>{

	List<Staza56417> findByPlanina56417(Planina56417 plan);

}
