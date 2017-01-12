package com.gaderesa.security;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gaderesa.domain.Oslp;
import com.gaderesa.repository.OslpRepository;





@Component
public class GaderesaOslpDetailsService implements UserDetailsService {

	@Autowired
	private OslpRepository oslpRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String slpName) throws UsernameNotFoundException {

		Oslp oslp = oslpRepository.findBySlpName(slpName);
		
		if(oslp == null){
			throw new UsernameNotFoundException(String.format("Usuario no encontrado", slpName));
		}
		List<GrantedAuthority> authorities = new ArrayList<>(); 
		if(oslp.isActive()){
			authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		}
		UserDetails userDetails = new org.springframework.security.core.userdetails.
				User(oslp.getSlpName(), oslp.getPassword(), authorities);
		
		
		return userDetails;
	}

}
