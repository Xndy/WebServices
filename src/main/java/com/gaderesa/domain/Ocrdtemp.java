/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaderesa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

/**
 *
 * @author Xndy
 */
@Entity
@Table(name="OCRDTEMP")
@Immutable
public class Ocrdtemp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CardCode", columnDefinition="nvarchar(15)")
    private String cardCode;
    @Column(name = "CardName", columnDefinition="nvarchar(100)")
    private String cardName;
    @Column(name = "CardType", columnDefinition="char(1)")
    private Character cardType;
    @Column(name = "GroupCode", columnDefinition="smallint")
    private Short groupCode;
    @Column(name = "CmpPrivate", columnDefinition="char(1)")
    private Character cmpPrivate;
    @Column(name = "MailAddres", columnDefinition="nvarchar(100)")
    private String mailAddres;
    @Column(name = "Phone1", columnDefinition="nvarchar(20)")
    private String phone1;
    @Column(name = "Phone2", columnDefinition="nvarchar(20)")
    private String phone2;
    @Column(name = "Fax", columnDefinition="nvarchar(20)")
    private String fax;
    @Column(name = "Notes", columnDefinition="nvarchar(100)")
    private String notes;
    @Column(name = "LicTradNum", columnDefinition="nvarchar(32)")
    private String licTradNum;
    @Column(name = "DdctStatus", columnDefinition="char(1)")
    private Character ddctStatus;
    @Column(name = "SlpCode")
    private Integer slpCode;
    @Column(name = "Currency", columnDefinition="nvarchar(3)")
    private String currency;
    @Column(name = "Cellular", columnDefinition="nvarchar(50)")
    private String cellular;
    @Column(name = "City", columnDefinition="nvarchar(100)")
    private String city;
    @Column(name = "County", columnDefinition="nvarchar(3)")
    private String county;
    @Column(name = "Country", columnDefinition="nvarchar(100)")
    private String country;
    @Column(name = "MailCity", columnDefinition="nvarchar(100)")
    private String mailCity;
    @Column(name = "MailCounty", columnDefinition="nvarchar(100)")
    private String mailCounty;
    @Column(name = "MailCountr", columnDefinition="nvarchar(3)")
    private String mailCountr;
    @Column(name = "E_Mail", columnDefinition="nvarchar(100)")
    private String eMail;
    @Column(name = "CardFName", columnDefinition="nvarchar(100)")
    private String cardFName;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "validFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;
    @Column(name = "ShipToDef", columnDefinition="nvarchar(50)")
    private String shipToDef;
    @Column(name = "TypWTReprt", columnDefinition="char(1)")
    private Character typWTReprt;
    @Column(name = "AddrType", columnDefinition="nvarchar(100)")
    private String addrType;
    @Column(name = "AliasName", columnDefinition="ntext")
    private String aliasName;
    @Column(name = "BillToDef", columnDefinition="nvarchar(50)")
    private String billToDef;
    @Column(name = "IntrntSite", columnDefinition="nvarchar(100)")
    private String intrntSite;
    @Column(name = "GlblLocNum", columnDefinition="nvarchar(50)")
    private String glblLocNum;
    @Column(name = "U_BPP_BPTD", columnDefinition="nvarchar(30)")
    private String u_bpp_bptd;
    @Column(name =" U_BPP_BPTP", columnDefinition="nvarchar(3)")
    private String  u_bpp_bptp;
    @Column(name="ProjectCod", columnDefinition="nvarchar(20)")
    private String projectCod;
    @Column(name="UserSign", columnDefinition="smallint")
    private Integer userSign;
    @Column(name="UserSign2", columnDefinition="smallint")
    private Integer userSign2;
    
    
    public Ocrdtemp() {
    }
    
    public Ocrdtemp(String cardCode, String cardName, String eMail) {
		super();
		this.cardCode = cardCode;
		this.cardName = cardName;
		this.eMail = eMail;
	}
    
	public String getCardCode() {
		return cardCode;
	}
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public Character getCardType() {
		return cardType;
	}
	public void setCardType(Character cardType) {
		this.cardType = cardType;
	}
	public Short getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(Short groupCode) {
		this.groupCode = groupCode;
	}
	public Character getCmpPrivate() {
		return cmpPrivate;
	}
	public void setCmpPrivate(Character cmpPrivate) {
		this.cmpPrivate = cmpPrivate;
	}
	
	public String getMailAddres() {
		return mailAddres;
	}
	public void setMailAddres(String mailAddres) {
		this.mailAddres = mailAddres;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getLicTradNum() {
		return licTradNum;
	}
	public void setLicTradNum(String licTradNum) {
		this.licTradNum = licTradNum;
	}
	public Character getDdctStatus() {
		return ddctStatus;
	}
	public void setDdctStatus(Character ddctStatus) {
		this.ddctStatus = ddctStatus;
	}
	public Integer getSlpCode() {
		return slpCode;
	}
	public void setSlpCode(Integer slpCode) {
		this.slpCode = slpCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCellular() {
		return cellular;
	}
	public void setCellular(String cellular) {
		this.cellular = cellular;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMailCity() {
		return mailCity;
	}
	public void setMailCity(String mailCity) {
		this.mailCity = mailCity;
	}
	public String getMailCounty() {
		return mailCounty;
	}
	public void setMailCounty(String mailCounty) {
		this.mailCounty = mailCounty;
	}
	public String getMailCountr() {
		return mailCountr;
	}
	public void setMailCountr(String mailCountr) {
		this.mailCountr = mailCountr;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getCardFName() {
		return cardFName;
	}
	public void setCardFName(String cardFName) {
		this.cardFName = cardFName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public String getShipToDef() {
		return shipToDef;
	}
	public void setShipToDef(String shipToDef) {
		this.shipToDef = shipToDef;
	}
	
	public Character getTypWTReprt() {
		return typWTReprt;
	}
	public void setTypWTReprt(Character typWTReprt) {
		this.typWTReprt = typWTReprt;
	}
	
	
	public String getAddrType() {
		return addrType;
	}
	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getBillToDef() {
		return billToDef;
	}
	public void setBillToDef(String billToDef) {
		this.billToDef = billToDef;
	}
	public String getIntrntSite() {
		return intrntSite;
	}
	public void setIntrntSite(String intrntSite) {
		this.intrntSite = intrntSite;
	}
	public String getGlblLocNum() {
		return glblLocNum;
	}
	public void setGlblLocNum(String glblLocNum) {
		this.glblLocNum = glblLocNum;
	}
	public String getU_bpp_bptd() {
		return u_bpp_bptd;
	}
	public void setU_bpp_bptd(String u_bpp_bptd) {
		this.u_bpp_bptd = u_bpp_bptd;
	}
	public String getU_bpp_bptp() {
		return u_bpp_bptp;
	}
	public void setU_bpp_bptp(String u_bpp_bptp) {
		this.u_bpp_bptp = u_bpp_bptp;
	}

	public String getProjectCod() {
		return projectCod;
	}

	public void setProjectCod(String projectCod) {
		this.projectCod = projectCod;
	}

	
	


	public Integer getUserSign() {
		return userSign;
	}

	public void setUserSign(Integer userSign) {
		this.userSign = userSign;
	}

	public Integer getUserSign2() {
		return userSign2;
	}

	public void setUserSign2(Integer userSign2) {
		this.userSign2 = userSign2;
	}

	public Ocrdtemp(String cardCode, String cardName, Character cardType, Short groupCode, String phone1, String phone2,
			String notes, String licTradNum, Integer slpCode, String cellular, String eMail, String glblLocNum,
			String projectCod, String cardFName) {
		super();
		this.cardCode = cardCode;
		this.cardName = cardName;
		this.cardType = cardType;
		this.groupCode = groupCode;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.notes = notes;
		this.licTradNum = licTradNum;
		this.slpCode = slpCode;
		this.cellular = cellular;
		this.eMail = eMail;
		this.glblLocNum = glblLocNum;
		this.projectCod = projectCod;
		this.cardFName = cardFName;
	}

	

	
	
	
    
   
}
