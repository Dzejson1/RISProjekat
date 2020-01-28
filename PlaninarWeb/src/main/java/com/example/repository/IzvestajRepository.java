package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Izvestaj56417;
import model.Planina56417;

public interface IzvestajRepository extends JpaRepository<Izvestaj56417, Integer>{

	List<Izvestaj56417> findByPlanina56417(Planina56417 planina);

}
