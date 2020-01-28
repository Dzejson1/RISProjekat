package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.PlaninaRepository;
import com.example.repository.RezervacijaSmestajaRepository;

import model.Planina56417;
import model.Rezervacijasmestaja56417;
import model.Tipznamenitosti56417;

@Controller
@RequestMapping(value = "/planinaController")
public class PlaninaController {

	@Autowired
	PlaninaRepository planRep;
	
	@Autowired
	RezervacijaSmestajaRepository rezRep;
	
	@RequestMapping(value = "/admin/pronadjStatistikuNocenja",method = RequestMethod.GET)
	public String pronadjStatistikuNocenj(String idP,HttpServletRequest request) {
		Planina56417 plan=planRep.findById(Integer.parseInt(idP)).get();
		List<Rezervacijasmestaja56417>rezervacije=rezRep.nadjiPlanine(plan.getIdPlanina());
		request.getSession().setAttribute("rezervacije", rezervacije);
		return "admin/prikaziStatistikuNocenja";
	}
	
	@RequestMapping(value = "/admin/prikaziSvePlanine",method = RequestMethod.GET)
	public String prikaziSvePlanine(HttpServletRequest request) {
		List<Planina56417>planina=planRep.findAll();
		request.getSession().setAttribute("planine", planina);
		return "admin/planineStat";
	}
	//obrisi
	@RequestMapping(value = "/admin/prikaziPlanine",method = RequestMethod.GET)
	public String prikaziPlanine(HttpServletRequest request) {
		List<Planina56417>planina=planRep.findAll();
		request.getSession().setAttribute("planine", planina);
		return "admin/izmeniPlaninu";
	}
	//III
	@RequestMapping(value = "/admin/prikaziCPlanine",method = RequestMethod.GET)
	public String prikaziCPlanine(HttpServletRequest request) {
		List<Planina56417>planina=planRep.findAll();
		request.getSession().setAttribute("planine", planina);
		return "admin/planina";
	}
	//I
	@RequestMapping(value = "/admin/pronadjiCPlaninu",method = RequestMethod.GET)
	public String pronadjiCPlaninu(String idP,HttpServletRequest request) {
		Planina56417 planina=planRep.findById(Integer.parseInt(idP)).get();
		request.getSession().setAttribute("planina", planina);
		return "admin/izmeniPlaninu";
	}
	//II
	@RequestMapping(value = "/admin/izmeniCPlaninu",method = RequestMethod.POST)
	public String izmeniCPlaninu(String idP,String naziv,HttpServletRequest request) {
		//Planina56417 planina=planRep.findById(Integer.parseInt(idP)).get();
		Planina56417 planina=(Planina56417)request.getSession().getAttribute("planina");
		planina.setNaziv(naziv);
		planRep.save(planina);
		return "redirect:/planinaController/admin/prikaziCPlanine";
	}
	//obrisi
	@RequestMapping(value = "/admin/izmeniPlaninu",method = RequestMethod.POST)
	public String izmeniPlaninu(String idP,String naziv,HttpServletRequest request) {
		Planina56417 planina=planRep.findById(Integer.parseInt(idP)).get();
		planina.setNaziv(naziv);
		planRep.save(planina);
		return "redirect:/planinaController/admin/prikaziPlanine";
	}
	
	@RequestMapping(value = "/admin/UnesiPlaninu",method = RequestMethod.POST)
	public String UnesiPlaninu(String naziv,HttpServletRequest request) {
		Planina56417 planina=new Planina56417();
		planina.setNaziv(naziv);
		planRep.save(planina);
		return "redirect:/planinaController/admin/prikaziCPlanine";
	}
	
	@RequestMapping(value = "/admin/getObrisiPlaninu",method = RequestMethod.POST)
	public String getObrisiPlaninu(HttpServletRequest request) {
		Planina56417 planina=new Planina56417();
		//planina.setNaziv(naziv);
		planRep.save(planina);
		return "admin/dodajPlaninu";
	}
	
}
