package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.KorisnikRepository;
import com.example.repository.PlaninaRepository;
import com.example.repository.PlaninarskiDomRepository;
import com.example.repository.RezervacijaSmestajaRepository;

import model.Komentar56417;
import model.Korisnik56417;
import model.Planina56417;
import model.Planinarskidom56417;
import model.Rezervacijasmestaja56417;

@Controller
@RequestMapping(value = "/rezervacijaSmestajaController")
public class RezervacijaSmestaja {
	
	@Autowired
	RezervacijaSmestajaRepository rezSmeRep;
	
	@Autowired
	KorisnikRepository korRep;
	
	@Autowired
	PlaninarskiDomRepository planDom;
	
	@Autowired
	PlaninaRepository planinaRep;
	
	@RequestMapping(value = "/user/prikaziPlanine",method = RequestMethod.GET)
	public String prikaziPlanine(HttpServletRequest request) {
		List<Planina56417>listaP=planinaRep.findAll();
		request.getSession().setAttribute("listaP", listaP);
		return "user/dom";
	}
	@RequestMapping(value = "/user/rezervisiSmestaj",method = RequestMethod.GET)
	public String rezervisiSmestaj(String idD,HttpServletRequest request) {
		Planinarskidom56417 dom=planDom.findById(Integer.parseInt(idD)).get();
		request.getSession().setAttribute("dom", dom);
		return "user/rezervisiSmestaj";
	}
	
	@RequestMapping(value = "/user/rezervisiSSmestaj",method = RequestMethod.POST)
	public String rezervisiSSmestaj(Date datum,HttpServletRequest request) {
		Planinarskidom56417 dom=(Planinarskidom56417)request.getSession().getAttribute("dom");
		UserDetails currentUser = (UserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		String username = currentUser.getUsername();
		Korisnik56417 user = korRep.findByUsername(username);
		Rezervacijasmestaja56417 rez=new Rezervacijasmestaja56417();
		rez.setDatum(datum);
		rez.setKorisnik56417(user);
		rez.setPlaninarskidom56417(dom);
		rezSmeRep.save(rez);
		return "redirect:/rezervacijaSmestajaController/user/prikaziPlanine";
		
	}
	
	
	@RequestMapping(value = "/user/prikaziDomove",method = RequestMethod.GET)
	public String prikaziDomove(String idP,HttpServletRequest request) {
		Planina56417 plan=planinaRep.findById(Integer.parseInt(idP)).get();
		List<Planinarskidom56417>listaD=planDom.findByPlanina56417(plan);
		request.getSession().setAttribute("listaD", listaD);
		return "user/prikazDomova";
	}
	
	
	
	@RequestMapping(value = "/user/getDodajRezervacijuSmestaja",method = RequestMethod.GET)
	public String getDodajRezervacijuSmestaja(HttpServletRequest request) {
		List<Korisnik56417>listaK=korRep.findAll();
		List<Planinarskidom56417>listaD=planDom.findAll();
		request.getSession().setAttribute("listaK", listaK);
		request.getSession().setAttribute("listaD", listaD);
		return "user/dodajRezervacijuSmestaja";
	}
	
	@RequestMapping(value = "/user/getIzmeniRezervacijuSmestaja",method = RequestMethod.GET)
	public String getIzmeniRezervacijuSmestaja(HttpServletRequest request) {
		List<Rezervacijasmestaja56417>listaR=rezSmeRep.findAll();
		List<Korisnik56417>listaK=korRep.findAll();
		List<Planinarskidom56417>listaD=planDom.findAll();
		request.getSession().setAttribute("listaR", listaR);
		request.getSession().setAttribute("listaK", listaK);
		request.getSession().setAttribute("listaD", listaD);
		return "user/izmeniRezervacijuSmestaja";
	}
	@RequestMapping(value = "/user/getObrisiRezervacijuSmestaja",method = RequestMethod.GET)
	public String getObrisiRezervacijuSmestaja(HttpServletRequest request) {
		List<Rezervacijasmestaja56417>listaR=rezSmeRep.findAll();
		request.getSession().setAttribute("listaR", listaR);
		return "user/obrisiRezervacijuSmestaja";
	}
	
	@RequestMapping(value = "/user/DodajRezervacijuSmestaja",method = RequestMethod.POST)
	public String dodajRezervacijuSmestaja(String idK,String idD,Date datum,HttpServletRequest request) {
		Rezervacijasmestaja56417 rez=new Rezervacijasmestaja56417();
		rez.setKorisnik56417(korRep.findById(Integer.parseInt(idK)).get());
		rez.setPlaninarskidom56417(planDom.findById(Integer.parseInt(idD)).get());
		rez.setDatum(datum);
		rezSmeRep.save(rez);
		
		
		return "redirect:/rezervacijaSmestajaController/user/getDodajRezervacijuSmestaja";
	}
	@RequestMapping(value = "/user/IzmeniRezervacijuSmestaja",method = RequestMethod.POST)
	public String IzmeniRezervacijuSmestaja(String idR,String idK,String idD,Date datum,HttpServletRequest request) {
		Rezervacijasmestaja56417 rez=rezSmeRep.findById(Integer.parseInt(idR)).get();
		rez.setKorisnik56417(korRep.findById(Integer.parseInt(idK)).get());
		rez.setPlaninarskidom56417(planDom.findById(Integer.parseInt(idD)).get());
		rez.setDatum(datum);
		rezSmeRep.save(rez);
		
		
		return "redirect:/rezervacijaSmestajaController/user/getIzmeniRezervacijuSmestaja";
	}
	@RequestMapping(value = "/user/ObrisiRezervacijuSmestaja",method = RequestMethod.POST)
	public String ObrisiRezervacijuSmestaja(String idR,Date datum,HttpServletRequest request) {
		Rezervacijasmestaja56417 rez=rezSmeRep.findById(Integer.parseInt(idR)).get();
		rezSmeRep.delete(rez);

		return "redirect:/rezervacijaSmestajaController/user/getObrisiRezervacijuSmestaja";
	}
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

}
