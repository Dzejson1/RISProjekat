package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.PlaninaRepository;

import model.Planina56417;
import model.Tipznamenitosti56417;

@Controller
@RequestMapping(value = "/planinaController")
public class PlaninaController {

	@Autowired
	PlaninaRepository planRep;
	
	@RequestMapping(value = "/admin/prikaziPlanine",method = RequestMethod.GET)
	public String prikaziPlanine(HttpServletRequest request) {
		List<Planina56417>planina=planRep.findAll();
		request.getSession().setAttribute("planine", planina);
		return "admin/izmeniPlaninu";
	}

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
		return "admin/dodajPlaninu";
	}
	
	@RequestMapping(value = "/admin/getObrisiPlaninu",method = RequestMethod.POST)
	public String getObrisiPlaninu(HttpServletRequest request) {
		Planina56417 planina=new Planina56417();
		//planina.setNaziv(naziv);
		planRep.save(planina);
		return "admin/dodajPlaninu";
	}
	
}
