
package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.KomentarRepository;
import com.example.repository.KorisnikRepository;
import com.example.repository.ZnamenitostRepository;

import model.Komentar56417;
import model.Korisnik56417;
import model.Planina56417;
import model.Znamenitost56417;

@Controller
@RequestMapping(value = "/komentarController")
public class KomentarController {
	
	@Autowired
	ZnamenitostRepository znamRep;
	
	@Autowired
	KorisnikRepository korisRep;
	
	@Autowired
	KomentarRepository komRep;
	
	
	
	@RequestMapping(value = "/user/unesiKomentarZ",method = RequestMethod.GET)
	public String unesiKomentarZ(String idZ,HttpServletRequest request) {
		Znamenitost56417 znam=znamRep.findById(Integer.parseInt(idZ)).get();
		request.getSession().setAttribute("znam", znam);
		return "user/dodajKomentar";
	}
	
	@RequestMapping(value = "/user/getDodajKomentar",method = RequestMethod.GET)
	public String getDodajKomentar(HttpServletRequest request) {
		List<Znamenitost56417>listaZ=znamRep.findAll();
		List<Korisnik56417>listaK=korisRep.findAll();
		request.getSession().setAttribute("listaZ", listaZ);
		request.getSession().setAttribute("listaK", listaK);
		return "user/dodajKomentar";
	}
	@RequestMapping(value = "/user/getObrisiKomentar",method = RequestMethod.GET)
	public String getObrisiKomentar(HttpServletRequest request) {
		List<Komentar56417>listaKom=komRep.findAll();
		request.getSession().setAttribute("listaKom", listaKom);
		return "user/obrisiKomentar";
	}
	
	@RequestMapping(value = "/user/DodajKomentar",method = RequestMethod.POST)
	public String DodajKomentar(String idZ,String idK,String opisK,HttpServletRequest request) {
		Znamenitost56417 zna=(Znamenitost56417)request.getSession().getAttribute("znam");
		UserDetails currentUser = (UserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		String username = currentUser.getUsername();
		Korisnik56417 user=korisRep.findByUsername(username);
		
		
		Komentar56417 kom=new Komentar56417();
		kom.setZnamenitost56417(zna);
		kom.setKorisnik56417(user);
		kom.setOpis(opisK);
		komRep.save(kom);
		return "user/prikaziZnamenitosti";
	}
	@RequestMapping(value = "/user/obrisiKomentar",method = RequestMethod.POST)
	public String obrisiKomentar(String idKom,HttpServletRequest request) {
		Komentar56417 kom=komRep.findById(Integer.parseInt(idKom)).get();
		komRep.delete(kom);
		return "redirect:/komentarController/user/getObrisiKomentar";
	}
	
	@RequestMapping(value = "/user/getIzmeniKomentar",method = RequestMethod.GET)
	public String getIzmeniKomentar(HttpServletRequest request) {
		List<Komentar56417>listaKom=komRep.findAll();
		List<Znamenitost56417>listaZ=znamRep.findAll();
		List<Korisnik56417>listaK=korisRep.findAll();
		request.getSession().setAttribute("listaKom", listaKom);
		request.getSession().setAttribute("listaZ", listaZ);
		request.getSession().setAttribute("listaK", listaK);
		return "user/izmeniKomentar";
	}
	@RequestMapping(value = "/user/izmeniKomentar",method = RequestMethod.POST)
	public String izmeniKomentar(String idKom,String idZ,String idK,String opisK,HttpServletRequest request) {
		Komentar56417 kom=komRep.findById(Integer.parseInt(idKom)).get();
		kom.setOpis(opisK);
		kom.setZnamenitost56417(znamRep.findById(Integer.parseInt(idZ)).get());
		kom.setKorisnik56417(korisRep.findById(Integer.parseInt(idK)).get());
		komRep.save(kom);
		return "redirect:/komentarController/user/getIzmeniKomentar";
	}
	
}
