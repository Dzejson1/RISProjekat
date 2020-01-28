package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Planina56417;
import model.Slika56417;

public interface SlikaRepository extends JpaRepository<Slika56417, Integer>{

	List<Slika56417> findByPlanina56417(Planina56417 planina);

}
