package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.StazaImage;
import com.example.repository.PlaninaRepository;
import com.example.repository.PlaninarskiDomRepository;

import model.Korisnik56417;
import model.Planina56417;
import model.Planinarskidom56417;
import model.Znamenitost56417;

@Controller
@RequestMapping(value = "/planinarskiDomController")
public class PlaninarskiDomController {
	
	@Autowired
	PlaninarskiDomRepository planDomRep;
	
	@Autowired
	PlaninaRepository planinaRep;
	
	@RequestMapping(value = "/admin/getDodajDom",method = RequestMethod.GET)
	public String dodajKorisnika(HttpServletRequest request) {
		List<Planina56417> listaPlan = planinaRep.findAll();
		request.getSession().setAttribute("listaPlan", listaPlan);
	
		
		return "admin/dodajDom";
	}
	@RequestMapping(value = "/admin/dodajDom",method = RequestMethod.POST)
	public String dodajDom(String idPl,String naziv,HttpServletRequest request) {
		Planina56417 plan=planinaRep.findById(Integer.parseInt(idPl)).get();
		Planinarskidom56417 dom=new Planinarskidom56417();
		dom.setPlanina56417(plan);
		dom.setNaziv(naziv);
		planDomRep.save(dom);
		return "redirect:/planinarskiDomController/admin/getDodajDom";
	}
	
	@RequestMapping(value = "/admin/getIzmeniDom",method = RequestMethod.GET)
	public String getIzmeniDom(HttpServletRequest request) {
		List<Planinarskidom56417>listaDom=planDomRep.findAll();
		List<Planina56417> listaPlan = planinaRep.findAll();
		request.getSession().setAttribute("listaPlan", listaPlan);
		request.getSession().setAttribute("listaDom", listaDom);
		
		return "admin/izmeniDom";
	}
	@RequestMapping(value = "/admin//izmeniDom",method = RequestMethod.POST)
	public String izmeniDom(String idDom,String idPl,String naziv,HttpServletRequest request) {
		Planina56417 plan=planinaRep.findById(Integer.parseInt(idPl)).get();
		Planinarskidom56417 dom=planDomRep.findById(Integer.parseInt(idDom)).get();
		dom.setPlanina56417(plan);
		dom.setNaziv(naziv);
		planDomRep.save(dom);
		return "redirect:/planinarskiDomController/admin/getIzmeniDom";
	}
	
}
