/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author delian
 */
@Entity
@Table(name = "ORG_BUSINESS")
@NamedQueries({
    @NamedQuery(name = "OrgBusiness.findAll", query = "SELECT o FROM OrgBusiness o"),
    @NamedQuery(name = "OrgBusiness.findById", query = "SELECT o FROM OrgBusiness o WHERE o.id = :id"),
    @NamedQuery(name = "OrgBusiness.findByCompanyname", query = "SELECT o FROM OrgBusiness o WHERE o.companyname = :companyname"),
    @NamedQuery(name = "OrgBusiness.findByPosition", query = "SELECT o FROM OrgBusiness o WHERE o.position = :position"),
    @NamedQuery(name = "OrgBusiness.findByBemail", query = "SELECT o FROM OrgBusiness o WHERE o.bemail = :bemail"),
    @NamedQuery(name = "OrgBusiness.findByBemail2", query = "SELECT o FROM OrgBusiness o WHERE o.bemail2 = :bemail2"),
    @NamedQuery(name = "OrgBusiness.findByBmobile", query = "SELECT o FROM OrgBusiness o WHERE o.bmobile = :bmobile"),
    @NamedQuery(name = "OrgBusiness.findByBmobile2", query = "SELECT o FROM OrgBusiness o WHERE o.bmobile2 = :bmobile2"),
    @NamedQuery(name = "OrgBusiness.findByFax", query = "SELECT o FROM OrgBusiness o WHERE o.fax = :fax")})
public class OrgBusiness implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "COMPANYNAME")
    private String companyname;
    @Size(max = 30)
    @Column(name = "POSITION")
    private String position;
    @Size(max = 30)
    @Column(name = "BEMAIL")
    private String bemail;
    @Size(max = 30)
    @Column(name = "BEMAIL2")
    private String bemail2;
    @Size(max = 30)
    @Column(name = "BMOBILE")
    private String bmobile;
    @Size(max = 30)
    @Column(name = "BMOBILE2")
    private String bmobile2;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "FAX")
    private String fax;
    @JoinColumn(name = "CONTACTS_ID", referencedColumnName = "ID")
    @ManyToOne
    private OrgContacts orgContacts;

    public OrgBusiness() {
    }

    public OrgBusiness(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

    public String getBemail2() {
        return bemail2;
    }

    public void setBemail2(String bemail2) {
        this.bemail2 = bemail2;
    }

    public String getBmobile() {
        return bmobile;
    }

    public void setBmobile(String bmobile) {
        this.bmobile = bmobile;
    }

    public String getBmobile2() {
        return bmobile2;
    }

    public void setBmobile2(String bmobile2) {
        this.bmobile2 = bmobile2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public OrgContacts getOrgContacts() {
        return orgContacts;
    }

    public void setOrgContacts(OrgContacts orgContacts) {
        this.orgContacts = orgContacts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgBusiness)) {
            return false;
        }
        OrgBusiness other = (OrgBusiness) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.organizer.db.OrgBusiness[ id=" + id + " ]";
    }
    
}
