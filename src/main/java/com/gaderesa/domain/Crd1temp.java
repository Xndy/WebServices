/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaderesa.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Immutable;

/**
 *
 * @author Xndy
 */
@Entity
@Table(name="CRD1TEMP")
@Immutable
public class Crd1temp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Address", columnDefinition="nvarchar(50)")
    private String address;
    @Column(name = "CardCode", columnDefinition="nvarchar(15)")
    private String cardCode;
    @Column(name = "Street", columnDefinition="nvarchar(100)")
    private String street;
    @Column(name = "City", columnDefinition="nvarchar(100)")
    private String city;
    @Column(name = "County", columnDefinition="nvarchar(3)")
    private String county;
    @Column(name = "Country", columnDefinition="nvarchar(100)")
    private String country;
    @Column(name = "AdresType", columnDefinition="char(1)")
    private Character adresType;
    @Column(name = "GlblLocNum", columnDefinition="nvarchar(50)")
    private String glblLocNum;
    @Column(name = "U_GAD_EMAELFACT", columnDefinition="nvarchar(250)")
    private String uGadEmaelfact;
    @Column(name = "U_GAD_DATECREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uGadDatecrea;
    @Column(name = "U_GAD_UPGPSANDROID", columnDefinition="ntext")
    private String uGadUpgpsandroid;
    
    public Crd1temp() {
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	


	public Character getAdresType() {
		return adresType;
	}

	public void setAdresType(Character adresType) {
		this.adresType = adresType;
	}

	public String getGlblLocNum() {
		return glblLocNum;
	}

	public void setGlblLocNum(String glblLocNum) {
		this.glblLocNum = glblLocNum;
	}

	public String getuGadEmaelfact() {
		return uGadEmaelfact;
	}

	public void setuGadEmaelfact(String uGadEmaelfact) {
		this.uGadEmaelfact = uGadEmaelfact;
	}

	public Date getuGadDatecrea() {
		return uGadDatecrea;
	}

	public void setuGadDatecrea(Date uGadDatecrea) {
		this.uGadDatecrea = uGadDatecrea;
	}

	public String getuGadUpgpsandroid() {
		return uGadUpgpsandroid;
	}

	public void setuGadUpgpsandroid(String uGadUpgpsandroid) {
		this.uGadUpgpsandroid = uGadUpgpsandroid;
	}

	
    
    
 }
