package com.gaderesa.controllers;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.gaderesa.domain.Ocrdtemp;
import com.gaderesa.repository.OcrdRepository;


@RestController

public class OcrdController {
	
	@Autowired
	private OcrdRepository ocrdRepository;
	
    @RequestMapping(value="/clientes", method = RequestMethod.POST)
	public ResponseEntity<?> saveOcrd(@RequestBody Ocrdtemp ocrd){
    	boolean exists = ocrdRepository.exists(ocrd.getCardCode());
    	if (exists == true)
    		return new ResponseEntity<> (exists, HttpStatus.ACCEPTED);
    	else 
    		ocrdRepository.saveClient(ocrd.getCardCode(), ocrd.getCardType(), ocrd.getCardName(), ocrd.getCardFName(), ocrd.getGroupCode()
    				, ocrd.getCmpPrivate(), ocrd.getLicTradNum(), ocrd.getPhone1(), ocrd.getPhone2(), ocrd.getCellular(), ocrd.geteMail()
    				, ocrd.getSlpCode(), ocrd.getNotes(), ocrd.getGlblLocNum(), ocrd.getProjectCod(), ocrd.getCountry(), ocrd.getCurrency()
    				, ocrd.getU_bpp_bptd(), ocrd.getUserSign(), ocrd.getCreateDate());
    		return new ResponseEntity<> (HttpStatus.OK);
	}

    @RequestMapping(value="/clientes", method = RequestMethod.GET)
    public ResponseEntity<List<Ocrdtemp>> findAll(Pageable pageable){
    	Page<Ocrdtemp> allClients = ocrdRepository.findAll(pageable);
        return new ResponseEntity<>(allClients.getContent(), HttpStatus.OK);
    }
    /*Metadata
     * @RequestMapping(value="/clientes", method = RequestMethod.GET)
    public ResponseEntity<Page<Ocrd>> findAll(Pageable pageable){
    	Page<Ocrd> allClients = ocrdRepository.findAll(pageable);
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }
     */
	
    @RequestMapping(value="/clients", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(@RequestParam(value="card_code", required=true) String card_code){
        return new ResponseEntity<>(ocrdRepository.getAllClient(card_code), HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value = "/clientcn",method = RequestMethod.GET)
    public ResponseEntity<List<Ocrdtemp>> findOne(@RequestParam(value="card_name", required=true) String card_name,Pageable pageable){
    	boolean exists = ocrdRepository.getFindClientExist(""+card_name+"%");
    	if (exists == true){
    		Page<Ocrdtemp> findOneClients = ocrdRepository.getFindOneClientLike(""+card_name+"%", pageable);
    		return new ResponseEntity<>(findOneClients.getContent(), HttpStatus.OK);
    		}
    	else 
    		return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        
        
    }
    
    /*Metadata
     * @RequestMapping(value = "/clientcn",method = RequestMethod.GET)
    public ResponseEntity<Page<Ocrd>> findOne(@RequestParam(value="card_name", required=true) String card_name,Pageable pageable){
    	boolean exists = ocrdRepository.getFindClientExist("%"+card_name+"%");
    	if (exists == true){
    		Page<Ocrd> findOneClients = ocrdRepository.getFindOneClientLike("%"+card_name+"%", pageable);
    		return new ResponseEntity<>(findOneClients., HttpStatus.OK);
    		}
    	else 
    		return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        
        
    }
     */
    
    @RequestMapping(value = "/client",method = RequestMethod.GET)
    public ResponseEntity<List<Ocrdtemp>> getClientByAsesor(@RequestParam(value="slp_code", required=true) Integer slp_code, Pageable pageable){
    	Page<Ocrdtemp> findClientByAsesor = ocrdRepository.getClientbyAsesor(slp_code, pageable);
    	return new ResponseEntity<>(findClientByAsesor.getContent(), HttpStatus.OK);
    }
    
    //METADATA
    /*
     * @RequestMapping(value = "/client",method = RequestMethod.GET)
    public ResponseEntity<Page<Ocrd>> getClientByAsesor(@RequestParam(value="slp_code", required=true) Integer slp_code, Pageable pageable){
    	Page<Ocrd> findClientByAsesor = ocrdRepository.getClientbyAsesor(slp_code, pageable);
    	return new ResponseEntity<>(findClientByAsesor, HttpStatus.OK);
    }
     */
    @RequestMapping(value="/clienteupdate", method = RequestMethod.POST)
	public ResponseEntity<?> updateOcrd(@RequestBody Ocrdtemp ocrd){
    	 
    		ocrdRepository.updateClient(ocrd.getCardCode(), ocrd.getCardType(), ocrd.getCardName(), ocrd.getCardFName(), ocrd.getGroupCode()
    				, ocrd.getCmpPrivate(), ocrd.getLicTradNum(), ocrd.getPhone1(), ocrd.getPhone2(), ocrd.getCellular(), ocrd.geteMail()
    				, ocrd.getSlpCode(), ocrd.getNotes(), ocrd.getGlblLocNum(), ocrd.getProjectCod(), ocrd.getCountry()
    				, ocrd.getU_bpp_bptd(), ocrd.getUserSign2(), ocrd.getUpdateDate());
    		return new ResponseEntity<> (HttpStatus.OK);
	}

}
