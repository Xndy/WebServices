package com.gaderesa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaderesa.repository.BpeTipidentRepository;

@RestController
public class BpeTipidentController {
	@Autowired
	private BpeTipidentRepository bpeTipidentRepository;
	
	
	@RequestMapping(value="/tipodocumento", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(bpeTipidentRepository.findAll(), HttpStatus.OK);
    }
	
	
}
