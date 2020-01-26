package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Korisnik56417;

public interface KorisnikRepository extends JpaRepository<Korisnik56417, Integer>{

	Korisnik56417 findByIme(String username);

	Korisnik56417 findByUsername(String username);

	

}
