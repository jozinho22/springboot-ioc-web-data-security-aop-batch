package com.douineau.testspringboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ApplicationUserDetailsService service;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//			.and()
			
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers(HttpMethod.GET, "/admin/authorities", "/admin/users").hasRole(ApplicationRole.ADMIN.name())
			.antMatchers(HttpMethod.GET, "/api/**").hasAuthority(ApplicationPermission.READ.name())
			.antMatchers(HttpMethod.POST, "/api/**").hasAuthority(ApplicationPermission.WRITE.name())
			.anyRequest().authenticated()
			.and()
			
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			
			.rememberMe()
			.rememberMeParameter("remember-me")
			.and()
			
			.logout()
			.logoutUrl("/logout")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout", HttpMethod.GET.name()))
			.clearAuthentication(true)
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID", "remember-me")
			.logoutSuccessUrl("/login")
			;

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthProvider());
	}
	
	public DaoAuthenticationProvider daoAuthProvider() {
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setPasswordEncoder(getPasswordEncoder());
		daoAuthProvider.setUserDetailsService(service);
		return daoAuthProvider;
	}
	
	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(getPasswordEncoder().encode("admin"))
				.roles(ApplicationRole.ADMIN.name()) // ROLE_ADMIN
				.authorities(ApplicationRole.ADMIN.getGrantedAuthorities())
				.build();
		
		UserDetails user = User.builder()
				.username("user")
				.password(getPasswordEncoder().encode("user"))
				.roles(ApplicationRole.USER.name()) // ROLE_ADMIN
				.authorities(ApplicationRole.USER.getGrantedAuthorities())
				.build();
		
		return new InMemoryUserDetailsManager(admin, user);
	}
	
}