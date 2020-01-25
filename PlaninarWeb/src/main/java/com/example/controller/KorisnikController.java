package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.KorisnikRepository;
import com.example.repository.RoleRepository;

import model.Korisnik56417;
import model.Role56417;
import model.Tipznamenitosti56417;

@Controller
@RequestMapping(value = "/korisnikController")
public class KorisnikController {

	@Autowired
	KorisnikRepository korisRep;
	
	@Autowired
	RoleRepository roleRep;
	
//	@RequestMapping(value = "registerUser", method = RequestMethod.GET)
//	public String newUser(Model model) {
//	PozoristeUser u = new PozoristeUser();
//	model.addAttribute("user", u);
//	return "register";
//}
// 
//@RequestMapping(value = "register", method = RequestMethod.POST)
//public String saveUser(@ModelAttribute("user") PozoristeUser u) {
//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    u.setPassword(passwordEncoder.encode(u.getPassword()));
//	
//    PozoristeRole role = proleRepo.findById(1).get();
//    
//	u.addRole(role);
//	role.addUser(u);
//    
//    pur.save(u);
//	System.out.println("SAVED");
//    return "login";
//}
	@RequestMapping(value = "/user/getDodajKorisnika", method = RequestMethod.GET)
	public String newUser(Model model) {
		Korisnik56417 k = new Korisnik56417();
		model.addAttribute("user", k);
		return "user/dodajKorisnika";
	}
	
	
	@RequestMapping(value = "/user/dodajKorisnika", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Korisnik56417 u,Date datum) {
		System.out.println(("usooooooooooooooooooooooo"));
	   // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	   // u.setPassword(passwordEncoder.encode(u.getPassword()));
		
	   // PozoristeRole role = proleRepo.findById(1).get();
	    Role56417 role=roleRep.findById(2).get();
		u.addRole(role);
		u.setDatumIsteka(datum);
		role.addUser(u);
	    korisRep.save(u);
	    //pur.save(u);
		System.out.println("SAVED");
		return "redirect:/korisnikController/user/getDodajKorisnika";
	}
	
	@RequestMapping(value = "/user/UnesiKorisnika",method = RequestMethod.POST)
	public String dodajKorisnika(String username,String password,String ime,String prezime,HttpServletRequest request) {
		System.out.println("--------------"+username+"---------"+password);
		Korisnik56417 korisnik=new Korisnik56417();
		korisnik.setUsername(username);
		korisnik.setPassword(password);
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisRep.save(korisnik);
		return "user/dodajKorisnika";
	}
	
	@RequestMapping(value = "/admin/UnesiKorisnika",method = RequestMethod.GET)
	public String dodajKorisnika(HttpServletRequest request) {
		List<Korisnik56417>korisnici=korisRep.findAll();
		request.getSession().setAttribute("korisnici", korisnici);
		return "admin/korisnik";
	}
	
	@RequestMapping(value = "/admin/promeniDatumIsteka",method = RequestMethod.GET)
	public String promeniDatumIsteka(String idK,HttpServletRequest request) {
		Korisnik56417 korisnik=korisRep.findById(Integer.parseInt(idK)).get();
		request.getSession().setAttribute("korisnik", korisnik);
		return "admin/izmeniDatum";
	}
	
	@RequestMapping(value = "/user/getIzmeniKorisnika",method = RequestMethod.GET)
	public String IzmeniKorisnika(HttpServletRequest request) {
		List<Korisnik56417>korisnici=korisRep.findAll();
		request.getSession().setAttribute("korisnici", korisnici);
		return "user/izmeniKorisnika";
	}
	 
	@RequestMapping(value = "/admin/izmeniDatumIsteka",method = RequestMethod.GET)
	public String izmeniDatumIsteka(Date datum,HttpServletRequest request) {
		Korisnik56417 kor=(Korisnik56417)request.getSession().getAttribute("korisnik");
		kor.setDatumIsteka(datum);
		  //return "redirect:/korisnikController/admin/UnesiKorisnik";     //STO NECE OVO A OCE OVAJ DOLE RETURN!!!!
		//return "redirect:/korisnikController/user/getIzmeniKorisnika";
		return "admin/korisnik";
	}
	
	@RequestMapping(value = "/user/izmeniKorisnika",method = RequestMethod.POST)
	public String izmeniKorisnika(String username,String password,String ime,String prezime,String idK,HttpServletRequest request) {
		Korisnik56417 kor=korisRep.findById(Integer.parseInt(idK)).get();
		kor.setUsername(username);
		kor.setPassword(password);
		kor.setIme(ime);
		kor.setPrezime(prezime);
		korisRep.save(kor);
		return "redirect:/korisnikController/user/getIzmeniKorisnika";
	}
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
