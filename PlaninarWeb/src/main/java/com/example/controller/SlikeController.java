package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.SlikeImage;
import com.example.domain.StazaImage;
import com.example.repository.KorisnikRepository;
import com.example.repository.PlaninaRepository;
import com.example.repository.SlikaRepository;

import model.Korisnik56417;
import model.Planina56417;
import model.Slika56417;
import model.Staza56417;
import model.Znamenitost56417;

@Controller
@RequestMapping(value = "/slikeController")
public class SlikeController {
	
	@Autowired
	KorisnikRepository korRep;
	
	@Autowired
	PlaninaRepository planRep;
	
	@Autowired
	SlikaRepository slikaRep;
	
	@RequestMapping(value = "/user/prikaziPlanineZaSLike",method = RequestMethod.GET)
	public String prikaziPlanineZaSLike(HttpServletRequest request,Model model) {
		List<Planina56417>listaP=planRep.findAll();
		request.getSession().setAttribute("listaP", listaP);
		return "user/slike";
	}
	
	
	@RequestMapping(value = "/user/getDodajSlike",method = RequestMethod.GET)
	public String getDodajRezervacijuSmestaja(String idP,HttpServletRequest request,Model model) {
		Planina56417 planina=planRep.findById(Integer.parseInt(idP)).get();
		request.getSession().setAttribute("planina", planina);
		SlikeImage s = new SlikeImage();
		model.addAttribute("slikaImg", s);
		return "user/dodajSliku";
	}
	
	@RequestMapping(value = "/user/pretraziSlike",method = RequestMethod.GET)
	public String pretraziSlike(String idS,HttpServletRequest request,Model model) {
		Slika56417 slika=slikaRep.findById(Integer.parseInt(idS)).get();
		request.getSession().setAttribute("slika", slika);
		return "user/pretraziSlike";
	}
	@RequestMapping(value = "/user/getIzmeniSlike",method = RequestMethod.GET)
	public String getIzmeniSlike(HttpServletRequest request,Model model) {
		List<Slika56417>listaS=slikaRep.findAll();
		List<Korisnik56417>listaK=korRep.findAll();
		List<Planina56417>listaP=planRep.findAll();
		request.getSession().setAttribute("listaS", listaS);
		request.getSession().setAttribute("listaK", listaK);
		request.getSession().setAttribute("listaP", listaP);
		SlikeImage s = new SlikeImage();
		model.addAttribute("slikaImg", s);
		return "user/izmeniSliku";
	}
	@RequestMapping(value = "/user/getObrisiSlike",method = RequestMethod.GET)
	public String getObrisiSlike(HttpServletRequest request) {
		List<Slika56417>listaS=slikaRep.findAll();
		
		request.getSession().setAttribute("listaS", listaS);
		
		
		return "user/obrisiSlike";
	}
	@RequestMapping(value = "/user/obrisiSlike",method = RequestMethod.POST)
	public String obrisiSlike(String idS,HttpServletRequest request) {
		Slika56417 slika=slikaRep.findById(Integer.parseInt(idS)).get();
		slikaRep.delete(slika);
		
		
		return "redirect:/slikeController/user/getObrisiSlike";
	}
	
	@RequestMapping(value = "/user/izmeniSlike", method = RequestMethod.POST)
	public String izmeniStazu(String idS,@ModelAttribute("slikaImg") @Valid SlikeImage ss, BindingResult result) {
		if (result.hasErrors()) {
			return "error";
		}
		System.out.println("-------------------");
		MultipartFile file = ss.getPic();
		if (null != file) {
			try {
				//Staza56417 im=stazaRep.findById(Integer.parseInt(idS)).get();
				Slika56417 im=slikaRep.findById(Integer.parseInt(idS)).get();
				im.setKorisnik56417(ss.getKorisnik56417());
				im.setPlanina56417(ss.getPlanina56417());

				im.setPic(file.getBytes());
				slikaRep.save(im);
				
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
		return "redirect:/slikeController/user/getIzmeniSlike";
	}
	
	
	@RequestMapping(value = "/user/get-image/{idSlik}", method = RequestMethod.GET)
	public void getImage(@PathVariable("idSlik") String idS, HttpServletResponse response,HttpServletRequest request) throws IOException {
		//System.out.println("-----------------------" + idZ);
		//System.out.println("usoooooooooooooooooooooooooooo");
		//Znamenitost56417 znam=znamRep.findById(Integer.parseInt(idZ)).get();
		Slika56417 slikaa=slikaRep.findById(Integer.parseInt(idS)).get();
		//System.out.println("-----------------------" + znam.getOpis());
		byte[] slika = slikaa.getPic();

		// response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

		response.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE);

		try {
			// Files.copy(Files.write(Paths.get("filename"), slika),
			// response.getOutputStream());
			response.getOutputStream().write(slika);
		} catch (Exception e) {

			e.printStackTrace();
		}
	
		request.getSession().setAttribute("slika", null);
	}
	
	
	@RequestMapping(value = "/user/DodajSlike", method = RequestMethod.POST)
	// public String UnesiStazu(String idDPlan,String opisS,HttpServletRequest
	// request) {
	public String saveSlika(@ModelAttribute("slikaImg") @Valid SlikeImage ss, BindingResult result,HttpServletRequest request) {

//		Planina56417 planina=planinaRep.findById(Integer.parseInt(idDPlan)).get();
//		Staza56417 staza=new Staza56417();
//		staza.setOpis(opisS);
//		staza.setPlanina56417(planina);
//		stazaRep.save(staza);

		if (result.hasErrors()) {
			return "error";
		}
		System.out.println("-------------------");
		MultipartFile file = ss.getPic();
		if (null != file) {
			// String fileName = file.getOriginalFilename();

			try {

				// cuva u sliku u bazi
				Slika56417 im=new Slika56417();
				UserDetails currentUser = (UserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
				String username = currentUser.getUsername();
				Korisnik56417 user = korRep.findByUsername(username);
				
				im.setKorisnik56417(user);
				im.setPlanina56417((Planina56417)request.getSession().getAttribute("planina"));
				im.setPic(file.getBytes());
				slikaRep.save(im);
			
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "user/slike";
	}
}
