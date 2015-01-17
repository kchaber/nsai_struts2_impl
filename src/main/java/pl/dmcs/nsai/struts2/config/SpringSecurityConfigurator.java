package pl.dmcs.nsai.struts2.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import pl.dmcs.nsai.struts2.services.UserService;

@Configuration
@EnableWebSecurity
@Order(1)
public class SpringSecurityConfigurator extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Autowired
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/images/**").permitAll()
				.antMatchers("/scripts/**").permitAll()
				.antMatchers("/views/**").permitAll()
			
				.antMatchers("/*listParking*").permitAll()
				.antMatchers("/*modifyParking*").permitAll()
				.antMatchers("/*listUser*").permitAll()
				.antMatchers("/*modifyUser*").permitAll()
				.antMatchers("/*Register*").permitAll()
			
				.antMatchers("/*Parking*").hasAnyRole(new String []{"USER","ADMIN"})
				.antMatchers("/*User*").hasAnyRole(new String []{"USER","ADMIN"})
				.antMatchers("/*PlaceReservation*").hasAnyRole(new String []{"USER","ADMIN"})
				.antMatchers("/*UserReservation*").hasAnyRole(new String []{"USER","ADMIN"})
			
			.and().rememberMe()
			.and().exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
				@Override
				public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException adex) throws IOException, ServletException {
					response.sendRedirect("inputLogin.action");
				}
			}) // doesn't work with annotation based restrictions*/
			.and()
				.formLogin()
				.loginPage("/inputLogin.action")
				.defaultSuccessUrl("/listParking.action")
				.permitAll()
			.and().logout().logoutSuccessUrl("/inputLogin.action");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

}
