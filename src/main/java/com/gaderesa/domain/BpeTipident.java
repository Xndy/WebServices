/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaderesa.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Xndy
 */
@Entity
@Table(name = "BPE_TIPIDENT")
public class BpeTipident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Code")
    private String code;
    @Column(name = "Name")
    private String name;
    @Column(name = "U_SYP_CODCOM")
    private String uSypCodcom;
    @Column(name = "U_SYP_CODVTA")
    private String uSypCodvta;
    @Column(name = "U_SYP_CODTJC")
    private String uSypCodtjc;
    @Column(name = "U_SYP_CODRFIN")
    private String uSypCodrfin;
    @Column(name = "U_SYP_CODFFI")
    private String uSypCodffi;

    public BpeTipident() {
    }

    public BpeTipident(String code) {
        this.code = code;
    }

    public BpeTipident(String code, String name) {
        this.code = code;
        this.name = name;
    }

    



    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getuSypCodcom() {
		return uSypCodcom;
	}

	public void setuSypCodcom(String uSypCodcom) {
		this.uSypCodcom = uSypCodcom;
	}

	public String getuSypCodvta() {
		return uSypCodvta;
	}

	public void setuSypCodvta(String uSypCodvta) {
		this.uSypCodvta = uSypCodvta;
	}

	public String getuSypCodtjc() {
		return uSypCodtjc;
	}

	public void setuSypCodtjc(String uSypCodtjc) {
		this.uSypCodtjc = uSypCodtjc;
	}

	public String getuSypCodrfin() {
		return uSypCodrfin;
	}

	public void setuSypCodrfin(String uSypCodrfin) {
		this.uSypCodrfin = uSypCodrfin;
	}

	public String getuSypCodffi() {
		return uSypCodffi;
	}

	public void setuSypCodffi(String uSypCodffi) {
		this.uSypCodffi = uSypCodffi;
	}

	@Override
    public String toString() {
        return "demoappgadere.BpeTipident[ code=" + code + " ]";
    }
    
}
