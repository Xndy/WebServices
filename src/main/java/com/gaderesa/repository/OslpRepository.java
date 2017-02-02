package com.gaderesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gaderesa.domain.Oslp;

public interface OslpRepository extends PagingAndSortingRepository<Oslp, Integer> {

	@Query(value = "select new com.gaderesa.domain.Oslp(o.slpCode, o.slpName, o.memo) from Oslp o where o.active = 'Y' order by o.slpName")
	public List<Oslp> getListAsesores ();	
	//and o.memo = 'Vendedor' or o.memo = 'Comprador' or o.memo = 'Operario'  DESPUES SITO
	
	@Query(value="select new com.gaderesa.domain.Oslp(o.slpCode, o.slpName, o.memo, o.userId) from Oslp o where o.slpName=?1 and  o.password=?2 ")
	public Oslp login(String slp_name,String password);
	
	
	public Oslp findBySlpName(String slpName);
	
	
	@Query(value = "select new com.gaderesa.domain.Oslp(o.slpName, o.position) from Oslp o where o.active = 'Y' order by o.slpName")
	public List<Oslp> getListAsesoresPosition();	
	
	
	@Query(value = "UPDATE OSLP SET position=?1 WHERE slpCode=?1", nativeQuery=true)
	public void UpdatePosition(String postion, Integer slpCode);	
	
	
	
	
}
