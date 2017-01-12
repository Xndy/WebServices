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


@Entity
@Table(name = "OPRJ")
public class Oprj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PrjCode")
    private String prjCode;
    @Column(name = "PrjName")
    private String prjName;
    @Column(name = "Locked")
    private Character locked;
    @Column(name = "DataSource")
    private Character dataSource;
    @Column(name = "UserSign")
    private Short userSign;
    @Column(name = "ValidFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;
    @Column(name = "ValidTo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validTo;
    @Column(name = "Active")
    private Character active;
    @Column(name = "LogInstanc")
    private Integer logInstanc;
    @Column(name = "UserSign2")
    private Short userSign2;
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Oprj() {
    }
    


    public Oprj(String prjCode, String prjName) {
		super();
		this.prjCode = prjCode;
		this.prjName = prjName;
	}



	public Oprj(String prjCode) {
        this.prjCode = prjCode;
    }

    public String getPrjCode() {
        return prjCode;
    }

    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode;
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName;
    }

    public Character getLocked() {
        return locked;
    }

    public void setLocked(Character locked) {
        this.locked = locked;
    }

    public Character getDataSource() {
        return dataSource;
    }

    public void setDataSource(Character dataSource) {
        this.dataSource = dataSource;
    }

    public Short getUserSign() {
        return userSign;
    }

    public void setUserSign(Short userSign) {
        this.userSign = userSign;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Integer getLogInstanc() {
        return logInstanc;
    }

    public void setLogInstanc(Integer logInstanc) {
        this.logInstanc = logInstanc;
    }

    public Short getUserSign2() {
        return userSign2;
    }

    public void setUserSign2(Short userSign2) {
        this.userSign2 = userSign2;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
   

    @Override
    public String toString() {
        return this.prjName;
    }
    
}
