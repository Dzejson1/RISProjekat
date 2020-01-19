package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.StazaImage;
import com.example.domain.ZnamenitostImage;
import com.example.repository.KomentarRepository;
import com.example.repository.StazaRepository;
import com.example.repository.TipZnamenitostiRepository;
import com.example.repository.ZnamenitostRepository;

import model.Komentar56417;
import model.Planina56417;
import model.Staza56417;
import model.Tipznamenitosti56417;
import model.Znamenitost56417;

@Controller
@RequestMapping(value = "/znamenitostController")
public class ZnamenitostController {

	@Autowired
	StazaRepository stazaRep;
	
	@Autowired
	TipZnamenitostiRepository tipZnamRep;
	
	@Autowired
	ZnamenitostRepository znamRep;
	@Autowired
	KomentarRepository komRep;
	
	@RequestMapping(value = "/admin/getDodajZnamenitost",method = RequestMethod.GET)
	public String getDodajZnamenitost(String opisS,HttpServletRequest request,Model model) {
		List<Staza56417>listaS=stazaRep.findAll();
		List<Tipznamenitosti56417>listaTR=tipZnamRep.findAll();
		ZnamenitostImage z=new ZnamenitostImage();
		model.addAttribute("znamImg", z);
		request.getSession().setAttribute("listaS", listaS);
		request.getSession().setAttribute("listaTR", listaTR);
		
		return "admin/dodajZnamenitost";
	}
	
	@RequestMapping(value = "/admin/getObrisiZnamenitost",method = RequestMethod.GET)
	public String getObrisiZnamenitost(String opisS,HttpServletRequest request) {
		List<Znamenitost56417>listaZ=znamRep.findAll();
		request.getSession().setAttribute("listaZ", listaZ);
		
		return "admin/obrisiZnamenitost";
	}
	
	@RequestMapping(value = "/admin/getIzmeniZnamenitost",method = RequestMethod.GET)
	public String getIzmeniZnamenitost(HttpServletRequest request,Model model) {
		List<Znamenitost56417>listaZ=znamRep.findAll();
		request.getSession().setAttribute("listaZ", listaZ);
		request.getSession().setAttribute("tipZ", tipZnamRep.findAll());
		request.getSession().setAttribute("staze", stazaRep.findAll());
		ZnamenitostImage z=new ZnamenitostImage();
		model.addAttribute("znamImg", z);
		return "admin/izmeniZnamenitost";
	}
	
	
	
	@RequestMapping(value = "/admin/ObrisiZnamenitost",method = RequestMethod.POST)
	public String ObrisiZnamenitost(String idZ,HttpServletRequest request) {
		Znamenitost56417 z=znamRep.findById(Integer.parseInt(idZ)).get();
		List<Komentar56417>listaK=komRep.findByZnamenitost56417(z);
		for(Komentar56417 k:listaK)
			komRep.delete(k);
		znamRep.delete(z);
		//return "admin/obrisiZnamenitost";
		return "redirect:/znamenitostController/admin/getObrisiZnamenitost";
	}
//	@RequestMapping(value = "/admin/dodajZnamenitost",method = RequestMethod.POST)
//	public String dodajZnamenitost(String idS,String idT,String opisZ,HttpServletRequest request) {
//		Staza56417 s=stazaRep.findById(Integer.parseInt(idS)).get();
//		Tipznamenitosti56417 tip=tipZnamRep.findById(Integer.parseInt(idT)).get();
//		Znamenitost56417 znam=new Znamenitost56417();
//		znam.setStaza56417(s);
//		znam.setTipznamenitosti56417(tip);
//		znam.setOpis(opisZ);
//		znamRep.save(znam);
//		return "admin/dodajZnamenitost";
//	}
	
	@RequestMapping(value = "/admin/izmeniZnamenitost", method = RequestMethod.POST)
	public String izmeniZnamenitost(String idZ,@ModelAttribute("znamImg") @Valid ZnamenitostImage ss, BindingResult result) {
		if (result.hasErrors()) {
			return "error";
		}
		MultipartFile file = ss.getSlika();
		if (null != file) {
			try {
				Znamenitost56417 znam=znamRep.findById(Integer.parseInt(idZ)).get();
				znam.setOpis(ss.getOpis());
				znam.setSlika(file.getBytes());
				znam.setTipznamenitosti56417(ss.getTipznamenitosti56417());
				znam.setStaza56417(ss.getStaza56417());
				if(ss.isPotrebnoZakPom())
					znam.setPotrebnoZakazati((byte)1);
				else
					znam.setPotrebnoZakazati((byte)0);
				znamRep.save(znam);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/znamenitostController/admin/getIzmeniZnamenitost";
	}
	
	@RequestMapping(value = "/admin/dodajZnamenitost",method = RequestMethod.POST)
	public String dodajZnamenitost(@ModelAttribute("znamImg") @Valid ZnamenitostImage ss, BindingResult result) {
		if (result.hasErrors()) {
			return "error";
		}
		System.out.println("-------------------");
		MultipartFile file = ss.getSlika();
		if (null != file) {
			try {
				Znamenitost56417 znam=new Znamenitost56417();
				
				znam.setOpis(ss.getOpis());
				znam.setTipznamenitosti56417(ss.getTipznamenitosti56417());
				znam.setStaza56417(ss.getStaza56417());
				znam.setSlika(file.getBytes());
				//znam.setPotrebnoZakazati(ss.isPotrebnoZakPom());
				if(ss.isPotrebnoZakPom())
					znam.setPotrebnoZakazati((byte)1);
				else
					znam.setPotrebnoZakazati((byte)0);
				znamRep.save(znam);
				
				// cuva u sliku u bazi
				//Staza56417 im = new Staza56417();
				//im.setOpis(ss.getOpis());
				//im.setPlanina56417(ss.getPlanina56417());
				//im.setMapa(file.getBytes());
				//stazaRep.save(im);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		//return "admin/izmeniStazu";
		return "redirect:/znamenitostController/admin/getDodajZnamenitost";
	}

	@RequestMapping(value = "/user/prikaziZnamenitost",method = RequestMethod.GET)
	public String prikaziZnamenitost(String idZ,HttpServletRequest request) {
		Znamenitost56417 znam=znamRep.findById(Integer.parseInt(idZ)).get();
		request.getSession().setAttribute("znam", znam);
		System.out.println("----------------"+znam.getIdZnamenitost());
		return "admin/pretraziZnamenitost";
	}
	
	@RequestMapping(value = "/user/get-image/{idZnam}", method = RequestMethod.GET)
	public void getImage(@PathVariable("idZnam") String idZ, HttpServletResponse response,HttpServletRequest request) throws IOException {
		System.out.println("-----------------------" + idZ);
		System.out.println("usoooooooooooooooooooooooooooo");
		Znamenitost56417 znam=znamRep.findById(Integer.parseInt(idZ)).get();
		System.out.println("-----------------------" + znam.getOpis());
		byte[] slika = znam.getSlika();

		// response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

		response.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE);

		try {
			// Files.copy(Files.write(Paths.get("filename"), slika),
			// response.getOutputStream());
			response.getOutputStream().write(slika);
		} catch (Exception e) {

			e.printStackTrace();
		}
	
		request.getSession().setAttribute("znam", null);
	}
	
	
	
}
