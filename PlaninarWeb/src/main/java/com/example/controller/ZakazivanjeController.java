package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.KorisnikRepository;
import com.example.repository.ZakazivanjeRepository;
import com.example.repository.ZnamenitostRepository;

import model.Korisnik56417;
import model.Zakazivanjeznamenitosti56417;
import model.Znamenitost56417;

@Controller
@RequestMapping(value = "/zakazivanjeController")
public class ZakazivanjeController {
	
	@Autowired
	ZakazivanjeRepository zakRep;
	
	@Autowired
	ZnamenitostRepository znamRep;
	
	@Autowired
	KorisnikRepository korisRep;
	
	@RequestMapping(value = "/user/getDodajZakazivanje",method = RequestMethod.GET)
	public String dodajKorisnika(HttpServletRequest request) {
	
		List<Znamenitost56417>listaZ=znamRep.findAll();
		List<Korisnik56417>listaK=korisRep.findAll();
	
		request.getSession().setAttribute("listaZ", listaZ);
		request.getSession().setAttribute("listaK", listaK);
		return "user/dodajZakazivanje";
	}
	@RequestMapping(value = "/user/getIzmeniZakazivanje",method = RequestMethod.GET)
	public String IzmeniZakazivanje(HttpServletRequest request) {
		List<Zakazivanjeznamenitosti56417>listaZak=zakRep.findAll();
		List<Znamenitost56417>listaZ=znamRep.findAll();
		List<Korisnik56417>listaK=korisRep.findAll();
		request.getSession().setAttribute("listaZak", listaZak);
		request.getSession().setAttribute("listaZ", listaZ);
		request.getSession().setAttribute("listaK", listaK);
		return "user/izmeniZakazivanje";
	}
	@RequestMapping(value = "/user/getObrisiZakazivanje",method = RequestMethod.GET)
	public String getObrisiZakazivanje(HttpServletRequest request) {
		List<Zakazivanjeznamenitosti56417>listaZ=zakRep.findAll();
		
		request.getSession().setAttribute("listaZ", listaZ);
		
		return "user/obrisiZakazivanje";
	}
	@RequestMapping(value = "/user/obrisiZakazivanje",method = RequestMethod.POST)
	public String obrisiZakazivanje(String idZ,HttpServletRequest request) {
		Zakazivanjeznamenitosti56417 zak=zakRep.findById(Integer.parseInt(idZ)).get();
		zakRep.delete(zak);
		
		return "redirect:/zakazivanjeController/user/getObrisiZakazivanje";
	}
	
	@RequestMapping(value = "/user/zakazi",method = RequestMethod.POST)
	public String zakazi(String idZ,String idK,Date datum,HttpServletRequest request) {
		Zakazivanjeznamenitosti56417 zak=new Zakazivanjeznamenitosti56417();
		zak.setDatum(datum);
		zak.setKorisnik56417(korisRep.findById(Integer.parseInt(idK)).get());
		zak.setZnamenitost56417(znamRep.findById(Integer.parseInt(idZ)).get());
		zakRep.save(zak);
		return "redirect:/zakazivanjeController/user/getDodajZakazivanje";
	}
	@RequestMapping(value = "/user/izmeniZakazivanje",method = RequestMethod.POST)
	public String izmeniZakazivanje(String idZak,String idZ,String idK,Date datum,HttpServletRequest request) {
		System.out.println("-----sdasdasdasdasd");
		Zakazivanjeznamenitosti56417 zak=zakRep.findById(Integer.parseInt(idZak)).get();
		zak.setDatum(datum);
		zak.setKorisnik56417(korisRep.findById(Integer.parseInt(idK)).get());
		zak.setZnamenitost56417(znamRep.findById(Integer.parseInt(idZ)).get());
		zakRep.save(zak);
		return "redirect:/zakazivanjeController/user/getIzmeniZakazivanje";
	}
//	@RequestMapping(value = "/user/getIzmeniZakazivanje",method = RequestMethod.GET)
//	public String izmeniZakazivanje(String idZak,String idZ,String idK,Date datum,HttpServletRequest request) {
//		Zakazivanjeznamenitosti56417 zak=zakRep.findById(Integer.parseInt(idZak)).get();
//		zak.setDatum(datum);
//		zak.setKorisnik56417(korisRep.findById(Integer.parseInt(idK)).get());
//		zak.setZnamenitost56417(znamRep.findById(Integer.parseInt(idZ)).get());
//		zakRep.save(zak);
//		return "redirect:/zakazivanjeController/user/getIzmeniZakazivanje";
//	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	

}
