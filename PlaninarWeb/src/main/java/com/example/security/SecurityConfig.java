package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

@Configuration
@EnableWebSecurity(debug=true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
		@Autowired
	    @Qualifier("customUserDetailsService")
	    UserDetailsService userDetailsService;
	 
			@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		      auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
			   
		}
			@Override
		protected void configure(HttpSecurity http) throws Exception {
				http
					.authorizeRequests()
					.antMatchers("/auth/**")
					.permitAll()
					.antMatchers("/izvestajControler/**",
							"/user/**",
							"/komentarController/**",
							"/korisnikController/**",
							"/rezervacijaSmestajaController/**",
							"/slikeController/**",
							"/stazaController/user/**",
							"/zakazivanjeController/**",
							"/znamenitostController/user/**")
						.hasAnyRole("user", "admin")
					.antMatchers("/planinaController/**",
							"/admin/**",
							"/planinarskiDomController/**", 
							"/stazaController/admin/**",
							"/tipZnamenitostiController/**",
							"/znamenitostController/admin/**")
					.hasRole("admin")
					.anyRequest().authenticated()
					.and()
					.formLogin()   
					.loginPage("/auth/loginPage") 
					.permitAll()
					.loginProcessingUrl("/login")
				    .and().csrf().disable()
				    .logout()
					.logoutUrl("/perform_logout")
					.invalidateHttpSession(true) ;
			}
}
