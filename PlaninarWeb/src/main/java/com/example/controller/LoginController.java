package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.KorisnikRepository;
import com.example.repository.RoleRepository;

import model.Korisnik56417;
import model.Role56417;



@Controller
@RequestMapping(value="/auth")
public class LoginController {

	//@Autowired
	//PozoristeUserRepository pur;
	
	//@Autowired
	//PozoristeRoleRepository proleRepo;

	@Autowired
	KorisnikRepository korisnikRep;
	
	@Autowired
	RoleRepository roleRep;
	
	@RequestMapping(value="loginPage", method=RequestMethod.GET) 
	public String loginPage() { 
		return "login";
	}
	
	
    @RequestMapping(value = "registerUser", method = RequestMethod.GET)
		public String newUser(Model model) {
		Korisnik56417 korisnik=new Korisnik56417();
		model.addAttribute("user", korisnik);
		return "user/register";
	}
	 
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user")Korisnik56417 u,String password) {
		System.out.println("--------------------------------------------------------"+u.getPassword());
		u.setPassword(password);
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    u.setPassword(passwordEncoder.encode(u.getPassword()));
		
	    //user
	   // Role56417 role = roleRep.findById(2).get();
	    
	    
	    //admin
	    Role56417 role = roleRep.findById(1).get();
	    
		u.addRole(role);
		role.addUser(u);
	    
	    korisnikRep.save(u);
		System.out.println("SAVED");
	    return "login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		return "redirect:/auth/loginPage";
	}

}
