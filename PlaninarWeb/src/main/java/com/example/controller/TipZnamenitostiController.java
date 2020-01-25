package com.example.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.TipZnamenitostiRepository;

import model.Korisnik56417;
import model.Planina56417;
import model.Planinarskidom56417;
import model.Rezervacijasmestaja56417;
import model.Staza56417;
import model.Tipznamenitosti56417;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/tipZnamenitostiController")
public class TipZnamenitostiController {

	@Autowired
	TipZnamenitostiRepository tipZnamRep;
	
	@RequestMapping(value = "/admin/UnesiTipZnamenitosti",method = RequestMethod.POST)
	public String UnesiTipZnamenitosti(String opis,HttpServletRequest request) {
		Tipznamenitosti56417 tipZ=new Tipznamenitosti56417();
		tipZ.setOpis(opis);
		tipZnamRep.save(tipZ);
		return "admin/dodajTipZnamenitosti";
	}
	@RequestMapping(value = "/admin/getEditTipoveZnamenitosti",method = RequestMethod.GET)
	public String getEditTipZnamenitosti(HttpServletRequest request) {
		List<Tipznamenitosti56417> listaTipZnam=tipZnamRep.findAll();
		request.getSession().setAttribute("listaEditTipZnam", listaTipZnam);
		return "admin/tipznamenitosti";
	}
	@RequestMapping(value = "/admin/getObrisiTipoveZnamenitosti",method = RequestMethod.GET)
	public String getObrisiTipZnamenitosti(HttpServletRequest request) {
		List<Tipznamenitosti56417> listaTipZnam=tipZnamRep.findAll();
		request.getSession().setAttribute("listaObrisiTipZnam", listaTipZnam);
		return "admin/obrisiTipZnamenitosti";
	}
	
	@RequestMapping(value = "/admin/obrisiTipZnamenitosti",method = RequestMethod.GET)
	public String obrisiTipZnamenitosti(String idTZ,HttpServletRequest request) {
		Tipznamenitosti56417 tipZ=tipZnamRep.findById(Integer.parseInt(idTZ)).get();
		
		//System.out.println("--------------------------------------------------------------------------------------------"+tipZ.getIdTipZnamenitosti());
		tipZnamRep.delete(tipZ);
		//System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		return "redirect:/tipZnamenitostiController/admin/getEditTipoveZnamenitosti";
	}
	
	
	@RequestMapping(value = "/admin/editTipoveZnamenitosti",method = RequestMethod.GET)
	public String editTipCZnamenitosti(String idTZ,HttpServletRequest request) {
		Tipznamenitosti56417 tipZ=tipZnamRep.findById(Integer.parseInt(idTZ)).get();
		request.getSession().setAttribute("tipZ", tipZ);
		return "admin/editTipZnamenitosti";
	}
	//brisi verovatno
	@RequestMapping(value = "/admin/editTipZnamenitosti",method = RequestMethod.POST)
	public String editTipZnamenitosti(String eOpis,HttpServletRequest request) {
		Tipznamenitosti56417 tipZ=(Tipznamenitosti56417)request.getSession().getAttribute("tipZ");
		tipZ.setOpis(eOpis);
		tipZnamRep.save(tipZ);
		return "redirect:/tipZnamenitostiController/admin/getEditTipoveZnamenitosti";
	}
	
}
