package com.example.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.StazaImage;
import com.example.repository.PlaninaRepository;
import com.example.repository.StazaRepository;

import model.Planina56417;
import model.Staza56417;

@Controller
@RequestMapping(value = "/stazaController")
public class StazaController {

	@Autowired
	StazaRepository stazaRep;

	@Autowired
	PlaninaRepository planinaRep;

//	@RequestMapping(value = "saveStudent", method = RequestMethod.GET)
//	public String inputStudent(Model model) {
//		Planinar s = new Planinar();
//		model.addAttribute("studentImg", s);
//		return "index1";
//	}

	@RequestMapping(value = "/admin/getDodajPlanine", method = RequestMethod.GET)
	public String getDodajPlanine(HttpServletRequest request, Model model) {
		List<Planina56417> listaPlan = planinaRep.findAll();
		request.getSession().setAttribute("listaPlan", listaPlan);
		StazaImage s = new StazaImage();
		model.addAttribute("stazaImg", s);
		return "admin/dodajStazu";
	}
	
	@RequestMapping(value = "/admin/prikaziCStaze", method = RequestMethod.GET)
	public String prikaziCStaze(HttpServletRequest request, Model model) {
		List<Staza56417> staze = stazaRep.findAll();
		request.getSession().setAttribute("staze", staze);
		return "admin/staze";
	}
	@RequestMapping(value = "admin/pronadjiCStazu", method = RequestMethod.GET)
	public String pronadjiCStazu(String idS,HttpServletRequest request, Model model) {
		Staza56417 staza=stazaRep.findById(Integer.parseInt(idS)).get();
		request.getSession().setAttribute("staza",staza);
		StazaImage s = new StazaImage();
		model.addAttribute("stazaImg", s);
		return "admin/izmeniStazu";
	}
	
	//obrisi
	@RequestMapping(value = "/admin/getIzmeniStaze", method = RequestMethod.GET)
	public String getIzmeniStaze(HttpServletRequest request, Model model) {
		List<Staza56417> staze = stazaRep.findAll();
		request.getSession().setAttribute("staze", staze);
		StazaImage s = new StazaImage();
		model.addAttribute("stazaImg", s);
		return "admin/izmeniStazu";
	}

	@RequestMapping(value = "/admin/izmeniStazu", method = RequestMethod.POST)
	public String izmeniStazu(@ModelAttribute("stazaImg") @Valid StazaImage ss, BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return "error";
		}
		System.out.println("-------------------");
		MultipartFile file = ss.getMapa();
		if (null != file) {
			try {
				Staza56417 im=(Staza56417)request.getSession().getAttribute("staza");
				im.setOpis(ss.getOpis());
				im.setTezina(ss.getTezina());
				im.setMapa(file.getBytes());
				stazaRep.save(im);
				
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
		return "redirect:/stazaController/admin/prikaziCStaze";
	}

	
	
	
	@RequestMapping(value = "/admin/UnesiStazu", method = RequestMethod.POST)
	// public String UnesiStazu(String idDPlan,String opisS,HttpServletRequest
	// request) {
	public String saveStaza(@ModelAttribute("stazaImg") @Valid StazaImage ss, BindingResult result) {

//		Planina56417 planina=planinaRep.findById(Integer.parseInt(idDPlan)).get();
//		Staza56417 staza=new Staza56417();
//		staza.setOpis(opisS);
//		staza.setPlanina56417(planina);
//		stazaRep.save(staza);

		if (result.hasErrors()) {
			return "error";
		}
		System.out.println("-------------------");
		MultipartFile file = ss.getMapa();
		if (null != file) {
			// String fileName = file.getOriginalFilename();

			try {

				// cuva u sliku u bazi
				Staza56417 im = new Staza56417();
				im.setOpis(ss.getOpis());
				im.setPlanina56417(ss.getPlanina56417());
				im.setMapa(file.getBytes());
				stazaRep.save(im);
			
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "admin/dodajStazu";
	}

	@RequestMapping(value = "/user/prikazi", method = RequestMethod.GET)
	public String nadji(String idStaza, HttpServletRequest request) {
		Staza56417 image = stazaRep.findById(Integer.parseInt(idStaza)).get();
		request.getSession().setAttribute("slika", image);
		//System.out.println("-----------------------" + image.getIdStaza());
		// Files.write(Paths.get("retrieve-dir/" + image.getOpis()
		// + "." + image.getType()), image.getPic());

		return "user/pretraziStazu";
	}

	@RequestMapping(value = "/user/get-image/{idStaza}", method = RequestMethod.GET)
	public void getImage(@PathVariable("idStaza") String idS, HttpServletResponse response,HttpServletRequest request) throws IOException {
		System.out.println("-----------------------" + idS);
		int is = Integer.parseInt(idS);
		Staza56417 s = stazaRep.findById(is).get();
		System.out.println("-----------------------" + s.getOpis());
		byte[] slika = s.getMapa();

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

}
