package com.gaderesa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gaderesa.domain.Oslp;
import com.gaderesa.repository.OslpRepository;

@RestController
public class OslpController {
	
	@Autowired
	private OslpRepository oslpRepository; 
	

    @RequestMapping(value="/asesor", method = RequestMethod.GET)
	public ResponseEntity<?> getAsesor(){
		return new ResponseEntity<>(oslpRepository.getListAsesores(), HttpStatus.OK);
	}
	
    
    @RequestMapping(value="/asesor/{slp_name}/{password}", method = RequestMethod.GET)
	public ResponseEntity<?> getAsesorExists(@PathVariable String slp_name, @PathVariable String password ){
    	Oslp oslp = oslpRepository.login(slp_name,password);
    	
    		return new ResponseEntity<>(oslp, HttpStatus.OK);
	}
    
    
    @RequestMapping(value="/asesor/position", method = RequestMethod.GET)
	public ResponseEntity<?> getAsesorPosition(){
		return new ResponseEntity<>(oslpRepository.getListAsesoresPosition(), HttpStatus.OK);
	}
	
    @RequestMapping (value = "/asesor/",method = RequestMethod.PUT)
    public ResponseEntity<?> updateAdviserPosition(@RequestBody Oslp oslp,@RequestParam(value="positionadviser", required=true) String position){
     oslpRepository.UpdatePosition(oslp.getPosition(), oslp.getSlpCode());
     return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
	
}
