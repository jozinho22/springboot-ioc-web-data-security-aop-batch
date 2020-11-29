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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.douineau.testspringboot.security.enums.ApplicationPermission;
import com.douineau.testspringboot.security.enums.ApplicationRole;
import com.douineau.testspringboot.security.jwt.JwtConfig;
import com.douineau.testspringboot.security.jwt.JwtTokenVerifier;
import com.douineau.testspringboot.security.jwt.JwtUsernameAndPasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;
	private final JwtConfig jwtConfig;
	private final ApplicationUserDetailsService service;

	@Autowired
	public WebSecurityConfig(PasswordEncoder passwordEncoder, JwtConfig jwtConfig,
			ApplicationUserDetailsService service) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.jwtConfig = jwtConfig;
		this.service = service;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// code to test
//		http.csrf().disable()
//			.authorizeRequests().anyRequest().permitAll();
			
		http.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			
			.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))
			.addFilterAfter(new JwtTokenVerifier(jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers(HttpMethod.GET, "/admin/authorities", "/admin/users").hasRole(ApplicationRole.ADMIN.name())
			.antMatchers(HttpMethod.GET, "/api/**").hasAuthority(ApplicationPermission.READ.name())
			.antMatchers(HttpMethod.POST, "/api/**").hasAuthority(ApplicationPermission.WRITE.name())
			.anyRequest().authenticated()
			;
		
// No need anaymore with JWT...
//			.and()
//			
//			.formLogin()
//			.loginPage("/login")
//			.permitAll()
//			.usernameParameter("username")
//			.passwordParameter("password")
//			.and()
//			
//			.rememberMe()
//			.rememberMeParameter("remember-me")
//			.and()
//			
//			.logout()
//			.logoutUrl("/logout")
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout", HttpMethod.GET.name()))
//			.clearAuthentication(true)
//			.invalidateHttpSession(true)
//			.deleteCookies("JSESSIONID", "remember-me")
//			.logoutSuccessUrl("/login");

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthProvider() {
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setPasswordEncoder(passwordEncoder);
		daoAuthProvider.setUserDetailsService(service);
		return daoAuthProvider;
	}
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(passwordEncoder.encode("admin"))
//				.roles(ApplicationRole.ADMIN.name()) // ROLES_ADMIN
//				.authorities(ApplicationRole.ADMIN.getGrantedAuthorities())
//				.build();
//		
//		UserDetails user = User.builder()
//				.username("user")
//				.password(passwordEncoder.encode("user"))
//				.roles(ApplicationRole.USER.name()) // ROLES_USER
//				.authorities(ApplicationRole.USER.getGrantedAuthorities())
//				.build();
//		
//		return new InMemoryUserDetailsManager(admin, user);
//	}
	
}