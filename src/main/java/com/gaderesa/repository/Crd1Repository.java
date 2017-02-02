package com.gaderesa.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.gaderesa.domain.Crd1temp;
import com.gaderesa.domain.Oslp;
public interface Crd1Repository extends PagingAndSortingRepository<Crd1temp, String>  {

	
    @Query(value = "SELECT c FROM Crd1temp c WHERE c.cardCode=?1", nativeQuery=true)
    public Iterable<Crd1temp> findByClient(String card_code);
    
    @Query
	(value = "SELECT  c FROM Crd1temp c WHERE c.cardCode IN"
			+ " (SELECT o.cardCode FROM Ocrdtemp o WHERE o.cardName LIKE :cardName ) AND c.adresType='S'")
	public Page<Crd1temp> getClientbyName(@Param("cardName") String card_name, Pageable pageable);
    
    
    
	@Query(value= "SELECT TOP 1 T4.[Address] ,  T4.[AdresType], T4.[CardCode],  T4.[City], T4.[Country], T4.[County] ,  T4.[GlblLocNum] ,"
    		+ " T4.[Street],  T4.[U_GAD_DATECREA], T4.[U_GAD_EMAELFACT], T4.[U_GAD_UPGPSANDROID] "
    		+ "FROM [BANCOS].[dbo].[ORDR] T0 INNER JOIN [BANCOS].[dbo].[OCRD] T2 ON T2.[CardCode] = T0.[CardCode]   "
    		+ "INNER JOIN [BANCOS].[dbo].[CRD1] T4 ON T4.[Address] = T0.[ShipToCode] AND T4.[AdresType] = 'S' AND T4.[CardCode] = T2.[CardCode] "
    		+ "WHERE T0.[DocNum]=?1 ", nativeQuery=true)
	public Crd1temp getClientbyDocnum(Integer docnum);
	
	@Query(value= "SELECT TOP 1 T4.[Address] ,  T4.[AdresType], T4.[CardCode],  T4.[City], T4.[Country], T4.[County] ,  T4.[GlblLocNum] ,"
    		+ " T4.[Street],  T4.[U_GAD_DATECREA], T4.[U_GAD_EMAELFACT], T4.[U_GAD_UPGPSANDROID] "
			+ "FROM [BANCOS].[dbo].[ORDR] T0 INNER JOIN [BANCOS].[dbo].[OCRD] T2 ON T2.[CardCode] = T0.[CardCode]   "
    		+ "INNER JOIN [BANCOS].[dbo].[CRD1] T4 ON T4.[Address] = T0.[ShipToCode] AND T4.[AdresType] = 'S' AND T4.[CardCode] = T2.[CardCode] "
    		+ "WHERE T0.[DocNum]=?1 ", nativeQuery=true)
	public Crd1temp getClientbyDocnumUpdateAndroid(Integer docnum);
    

    @Modifying
    @Transactional
    @Query
    (value = "EXEC [GADEREAPP].[dbo].[GADUpdateGeolocation] @Address=?1, @CardCode=?2, @Street=?3, @GlblLocNum=?4", nativeQuery = true)
    public void updateCrd1(String address, String CardCode, String Street, String glbl_loc_num);
    
    
    
    @Query(value = "SELECT COUNT(*) from [BANCOS].[dbo].[ORDR] where [DocNum]=?1", nativeQuery=true)
    public Integer existManifest(Integer docnum);
   
    
    
    
    

    @Modifying
    @Transactional
    @Query(value = "DECLARE @docnum int,@address nvarchar (250), @addrestype char (1), @street nvarchar (250), @cardcode nvarchar (50), @beforegps nvarchar(250)  "
    		+ "SELECT @docnum = T0.[DocNum], @address = T4.[Address] , @addrestype = T4.[AdresType], @street = T4.[Street] , @cardcode = T4.[CardCode], @beforegps = T4.[GlblLocNum] "
    		+ "FROM [BANCOS].[dbo].[ORDR] T0 INNER JOIN [BANCOS].[dbo].[OCRD] T2 ON T2.[CardCode] = T0.[CardCode]   "
    		+ "INNER JOIN [BANCOS].[dbo].[CRD1] T4 ON T4.[Address] = T0.[ShipToCode] AND T4.[AdresType] = 'S' AND T4.[CardCode] = T2.[CardCode] "
    		+ "WHERE T0.[DocNum]=?1 "
    		+ "INSERT INTO [GADEREAPP].[dbo].[logofflineandroid]([docnum], [address],[street],[cardcode], [beforegps] )  "
    		+ "VALUES (@docnum, @address, @street, @cardcode, @beforegps)  "
    		+ "UPDATE [APP].[dbo].[CRD1TEMP]  SET [CRD1TEMP].[GlblLocNum]=?2 WHERE [CRD1TEMP].[Address] = @address AND [CRD1TEMP].[AdresType] = @addrestype  "
    		+ "AND [CRD1TEMP].[CardCode] = @cardcode", nativeQuery=true)
    public void saveUpdateOffline(Integer docnum, String glbl_loc_num);
    
    
}
