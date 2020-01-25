package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Zakazivanjeznamenitosti56417;
import model.Znamenitost56417;

public interface ZakazivanjeRepository extends JpaRepository<Zakazivanjeznamenitosti56417, Integer>{

	List<Zakazivanjeznamenitosti56417> findByZnamenitost56417(Znamenitost56417 z);

	

}
