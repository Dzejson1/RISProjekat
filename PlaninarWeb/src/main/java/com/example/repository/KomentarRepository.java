package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Komentar56417;
import model.Znamenitost56417;

public interface KomentarRepository extends JpaRepository<Komentar56417, Integer>{

	List<Komentar56417> findByZnamenitost56417(Znamenitost56417 z);

}
