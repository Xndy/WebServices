package com.gaderesa.controllers;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaderesa.repository.OprjRepository;

@RestController 
public class OprjController {

	@Autowired
	private OprjRepository oprjRepository;
	
	
	@RequestMapping(value="/proyecto", method=RequestMethod.GET)
	public ResponseEntity<?> finAll(){
		return new ResponseEntity<>(oprjRepository.getAllProjects(), HttpStatus.OK);
	}
	
	

}
