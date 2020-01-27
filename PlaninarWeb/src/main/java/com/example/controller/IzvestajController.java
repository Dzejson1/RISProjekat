package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.IzvestajRepository;
import com.example.repository.KorisnikRepository;
import com.example.repository.PlaninaRepository;

import model.Izvestaj56417;
import model.Korisnik56417;
import model.Planina56417;


@Controller
@RequestMapping(value = "/izvestajController")
public class IzvestajController {
	
	@Autowired
	KorisnikRepository korRep;
	
	@Autowired
	PlaninaRepository planRep;
	
	@Autowired
	IzvestajRepository izvRep;
	
	@RequestMapping(value = "/user/prikaziPlanineZaIzvestaj",method = RequestMethod.GET)
	public String prikaziPlanineZaIzvestaj(HttpServletRequest request) {
		List<Planina56417>listaP=planRep.findAll();
		request.getSession().setAttribute("listaP", listaP);
		return "user/izvestaj";
	}
	
	
	@RequestMapping(value = "/user/getDodajIzvestaj",method = RequestMethod.GET)
	public String getDodajRezervacijuSmestaja(String idP,HttpServletRequest request) {
	
		Planina56417 planina=planRep.findById(Integer.parseInt(idP)).get();
		request.getSession().setAttribute("planina", planina);
		return "user/dodajIzvestaj";
	}
	
	@RequestMapping(value = "/user/getIzmeniIzvestaj",method = RequestMethod.GET)
	public String izmeniIzvestaj(HttpServletRequest request) {
		List<Izvestaj56417>listaI=izvRep.findAll();
		List<Korisnik56417>listaK=korRep.findAll();
		List<Planina56417>listaP=planRep.findAll();
		request.getSession().setAttribute("listaI", listaI);
		request.getSession().setAttribute("listaK", listaK);
		request.getSession().setAttribute("listaP", listaP);
		return "user/izmeniIzvestaj";
	}
	@RequestMapping(value = "/user/getObrisiIzvestaj",method = RequestMethod.GET)
	public String getObrisiIzvestaj(HttpServletRequest request) {
		List<Izvestaj56417>listaI=izvRep.findAll();
	
		request.getSession().setAttribute("listaI", listaI);
		
		return "user/obrisiIzvestaj";
	}
	
	@RequestMapping(value = "/user/DodajIzvestaj",method = RequestMethod.POST)
	public String dodajIzvestaj(String idK,String idP,String izvestaj,HttpServletRequest request) {
		Izvestaj56417 izve=new Izvestaj56417();
		UserDetails currentUser = (UserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		String username = currentUser.getUsername();
		Korisnik56417 user = korRep.findByUsername(username);
		
		izve.setKorisnik56417(user);
		izve.setPlanina56417((Planina56417)request.getSession().getAttribute("planina"));
		izve.setOpis(izvestaj);
		izvRep.save(izve);
		return "user/izvestaj";
	}
	@RequestMapping(value = "/user/IzmeniIzvestaj",method = RequestMethod.POST)
	public String izmeniIzvestaj(String idI,String idK,String idP,String izvestaj,HttpServletRequest request) {
		Izvestaj56417 izve=izvRep.findById(Integer.parseInt(idI)).get();
		izve.setKorisnik56417(korRep.findById(Integer.parseInt(idK)).get());
		izve.setPlanina56417(planRep.findById(Integer.parseInt(idP)).get());
		izve.setOpis(izvestaj);
		izvRep.save(izve);
		return "redirect:/izvestajController/user/getIzmeniIzvestaj";
	}
	@RequestMapping(value = "/user/ObrisiIzvestaj",method = RequestMethod.POST)
	public String obrisiIzvestaj(String idI,HttpServletRequest request) {
		Izvestaj56417 izve=izvRep.findById(Integer.parseInt(idI)).get();
		
		izvRep.delete(izve);
		return "redirect:/izvestajController/user/getObrisiIzvestaj";
	}
	
}
