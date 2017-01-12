package com.gaderesa.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;

import com.gaderesa.domain.Ocrdtemp;

public interface OcrdRepository extends PagingAndSortingRepository<Ocrdtemp, String> {
	
	@Query(value="SELECT o.* FROM Ocrdtemp o where o.card_code=?1",  nativeQuery = true)
	public List<Ocrdtemp> getAllClient( @Param("card_code") String card_code);
	
	@Query(value="SELECT new com.gaderesa.domain.Ocrdtemp(o.cardCode, o.cardName, o.cardType, o.groupCode, o.phone1,"
			+ "o.phone2, o.notes, o.licTradNum, o.slpCode, o.cellular, o.eMail, o.glblLocNum, o.projectCod, o.cardFName ) FROM Ocrdtemp o where o.slpCode=?1")
	 public Page<Ocrdtemp> getClientbyAsesor(Integer slp_code, Pageable pageable);
	 

    @Query
	(value = "SELECT  new com.gaderesa.domain.Ocrdtemp(o.cardCode, o.cardName, o.cardType, o.groupCode, o.phone1,"
			+ "o.phone2, o.notes, o.licTradNum, o.slpCode, o.cellular, o.eMail, o.glblLocNum, o.projectCod, o.cardFName )"
			+ " FROM  Ocrdtemp o  WHERE o.cardName LIKE :cardName")
	public Page<Ocrdtemp> getFindOneClientLike(@Param("cardName") String cardName, Pageable pageable);
	
    
    @Query
    (value="SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END from Ocrdtemp o where o.cardName LIKE :cardName")
    public boolean getFindClientExist(@Param("cardName") String cardName);
    
    @Modifying
    @Transactional
    @Query
    (value="EXEC [GADEREAPP].[dbo].[GADINSERTOCRD]"
    		+ " @CardCode=?1, @cardType=?2, @cardName=?3, @cardFName=?4, @groupCode=?5, @cmpPrivate=?6"
    		+ ", @licTradNum=?7, @phone1=?8, @phone2=?9, @cellular=?10, @eMail=?11"
    		+ ", @slpCode=?12, @notes=?13, @GlblLocNum=?14,@projectCod=?15, @country=?16,@currency=?17"
    		+ ",@u_bpp_bptd=?18, @userSign=?19, @createDate=?20", nativeQuery = true)
    public void saveClient(String CardCode,  Character cardType, String cardName, String cardFName, Short groupCode,
    		 Character cmpPrivate, String licTradNum,  String phone1,  String phone2, String cellular,  String eMail,
    		 Integer slpCode,  String notes, String glblLocNumm, String projectCod, String country, String currency,
    		 String  u_bpp_bptd, Integer userSign, Date createDate);

    

    @Modifying
    @Transactional
    @Query
    (value="EXEC [GADEREAPP].[dbo].[GADUPDATEOCRD] "
    		+ " @CardCode=?1, @cardType=?2, @cardName=?3, @cardFName=?4, @groupCode=?5, @cmpPrivate=?6"
    		+ ", @licTradNum=?7, @phone1=?8, @phone2=?9, @cellular=?10, @eMail=?11"
    		+ ", @slpCode=?12, @notes=?13, @GlblLocNum=?14,@projectCod=?15, @country=?16"
    		+ ",@u_bpp_bptd=?17, @userSign2=?18, @updateDate=?19", nativeQuery = true)
    public void updateClient(String CardCode,  Character cardType, String cardName, String cardFName, Short groupCode,
    		 Character cmpPrivate, String licTradNum,  String phone1,  String phone2, String cellular,  String eMail,
    		 Integer slpCode,  String notes, String glblLocNumm, String projectCod, String country,
    		 String  u_bpp_bptd, Integer userSign, Date updateDate);
   
    
	 
}
