package com.gaderesa;

import javax.inject.Inject;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.
AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.
WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.method.configuration.
EnableGlobalMethodSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Inject
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
        .withUser("admin")
        .password("1234")
        .roles("ADMIN")
        .and()
        .withUser("user2")
        .password("password2")
        .roles("USER");
		System.out.println(""
				+ "hola mundo");*/
		auth.userDetailsService(userDetailsService);
//		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().anyRequest().fullyAuthenticated().and().
	    httpBasic().and().
	    csrf().disable();
		*/
		/*http
		//.sessionManagement()
		//.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		//.and().
		.authorizeRequests().anyRequest().fullyAuthenticated()
		.and().formLogin().loginProcessingUrl("/login").and()
		.httpBasic()
		.realmName("gaderesa")
		.and()
		.csrf()
		.disable();
*/

		http
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().
		authorizeRequests().anyRequest().fullyAuthenticated()
		.and()
		.httpBasic()
		.realmName("gaderesa")
		.and()
		.csrf()
		.disable();
		
	}
	
	
	
}
