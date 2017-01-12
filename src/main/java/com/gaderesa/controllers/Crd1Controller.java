package com.gaderesa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.gaderesa.domain.Crd1temp;
import com.gaderesa.repository.Crd1Repository;

@RestController
public class Crd1Controller {
	
	 @Autowired
	 private Crd1Repository crd1Repository;
/*
	 @RequestMapping(value = "/clientes/{card_code}/sucursal", method = RequestMethod.POST, headers="Accept=application/xml, application/json")
	 public  @ResponseBody ResponseEntity<?> save(@RequestBody Crd1 crd1){
		return new ResponseEntity<> (crd1Repository.save(crd1), HttpStatus.CREATED);
	 }
	 */
	 //@RequestMapping(value = "/clientes/{card_code}/sucursal", method = RequestMethod.GET)
	//    public ResponseEntity<?> findAll(){
	 //       return new ResponseEntity<>(crd1Repository.findAll(), HttpStatus.OK);
	// }
	    /*
	 @RequestMapping(value = "/clientes/{card_code}/sucursal", method = RequestMethod.GET)
	    public ResponseEntity<?> findAll(@PathVariable String card_code, @RequestParam(defaultValue = "false") boolean get){
		 if(!get)
	            return new ResponseEntity<>(crd1Repository.findByClient(card_code), HttpStatus.OK);
		 else 
			 	return new ResponseEntity<>(crd1Repository.findByClient(card_code), HttpStatus.OK);
	    }
	 */
	/* @RequestMapping(value = "/clientes/nombre/{card_name}",method = RequestMethod.GET)
	    public ResponseEntity<?> findOnebyName(@PathVariable String card_name){
	        return new ResponseEntity<>(crd1Repository.getClientbyName(card_name), HttpStatus.OK);
	    }
	 */
	 @Transactional(readOnly=true)
	 @RequestMapping(value = "/clientsucur",method = RequestMethod.GET)
	   public ResponseEntity<List<Crd1temp>> getSucursalByClient(@RequestParam(value="cardName", required=true) String cardName, Pageable pageable ){
		 Page<Crd1temp> findSucursalByClient = crd1Repository.getClientbyName(""+cardName+"%", pageable);  
		 return new ResponseEntity<>(findSucursalByClient.getContent(), HttpStatus.OK);
	   }
	 
	 
	 /*Metadata
	  * @Transactional(readOnly=true)
	 @RequestMapping(value = "/clientsucur",method = RequestMethod.GET)
	   public ResponseEntity<Page<Crd1>> getSucursalByClient(@RequestParam(value="cardName", required=true) String cardName, Pageable pageable ){
		 Page<Crd1> findSucursalByClient = crd1Repository.getClientbyName("%"+cardName+"%", pageable);  
		 return new ResponseEntity<>(findSucursalByClient, HttpStatus.OK);
	   }
	  */
	 
	 
	 @RequestMapping (value = "/clientsucur",method = RequestMethod.PUT)
	    public ResponseEntity<?> updateCrd1(@RequestBody Crd1temp crd1,@RequestParam(value="address", required=true) String address){
		 crd1Repository.updateCrd1(crd1.getAddress(), crd1.getCardCode(), crd1.getStreet(), crd1.getGlblLocNum() );
	     return new ResponseEntity<>(HttpStatus.OK);
	    }
	 
	 
	 @RequestMapping (value = "/clientes/clientsucur",method = RequestMethod.POST)
	    public ResponseEntity<?> updateCrd1Offline(@RequestBody Crd1temp crd1){
		  Integer exists = crd1Repository.existManifest(Integer.parseInt(crd1.getCardCode()));                             
		 //crd1Repository.updateCrd1(crd1.getAddress(), crd1.getCardCode(), crd1.getStreet(), crd1.getGlblLocNum() );
		  
		  if(exists == 0){
			  boolean x = true;
			  return new ResponseEntity<> (x, HttpStatus.ACCEPTED);
		  }
		  else {
			  crd1Repository.saveUpdateOffline(Integer.parseInt(crd1.getCardCode()), crd1.getGlblLocNum());
			  return new ResponseEntity<>(HttpStatus.OK);
		  }
		  
	    }
	 
	 
	 
	 
}
