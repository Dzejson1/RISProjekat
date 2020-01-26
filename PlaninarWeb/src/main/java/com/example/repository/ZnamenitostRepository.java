package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Staza56417;
import model.Tipznamenitosti56417;
import model.Znamenitost56417;

public interface ZnamenitostRepository  extends JpaRepository<Znamenitost56417, Integer>{

	List<Znamenitost56417> findByTipznamenitosti56417(Tipznamenitosti56417 tipZ);

	List<Znamenitost56417> findByStaza56417(Staza56417 staza);

}
