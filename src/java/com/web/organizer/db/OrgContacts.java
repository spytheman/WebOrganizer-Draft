/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.db;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author delian
 */
@Entity
@Table(name = "ORG_CONTACTS")
@NamedQueries({
    @NamedQuery(name = "OrgContacts.findAll", query = "SELECT o FROM OrgContacts o"),
    @NamedQuery(name = "OrgContacts.findById", query = "SELECT o FROM OrgContacts o WHERE o.id = :id"),
    @NamedQuery(name = "OrgContacts.findByCfirstname", query = "SELECT o FROM OrgContacts o WHERE o.cfirstname = :cfirstname"),
    @NamedQuery(name = "OrgContacts.findByClastname", query = "SELECT o FROM OrgContacts o WHERE o.clastname = :clastname"),
    @NamedQuery(name = "OrgContacts.findByCemail", query = "SELECT o FROM OrgContacts o WHERE o.cemail = :cemail"),
    @NamedQuery(name = "OrgContacts.findByCemail2", query = "SELECT o FROM OrgContacts o WHERE o.cemail2 = :cemail2"),
    @NamedQuery(name = "OrgContacts.findByCmobile", query = "SELECT o FROM OrgContacts o WHERE o.cmobile = :cmobile"),
    @NamedQuery(name = "OrgContacts.findByCmobile2", query = "SELECT o FROM OrgContacts o WHERE o.cmobile2 = :cmobile2"),
    @NamedQuery(name = "OrgContacts.findByCcountry", query = "SELECT o FROM OrgContacts o WHERE o.ccountry = :ccountry")})
public class OrgContacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CFIRSTNAME")
    private String cfirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CLASTNAME")
    private String clastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CEMAIL")
    private String cemail;
    @Size(max = 30)
    @Column(name = "CEMAIL2")
    private String cemail2;
    @Size(max = 30)
    @Column(name = "CMOBILE")
    private String cmobile;
    @Size(max = 30)
    @Column(name = "CMOBILE2")
    private String cmobile2;
    @Size(max = 30)
    @Column(name = "CCOUNTRY")
    private String ccountry;
    @OneToMany(mappedBy = "orgContacts")
    private Collection<OrgBusiness> orgBusinessCollection;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private OrgUsers orgUsers;

    public OrgContacts() {
    }

    public OrgContacts(Integer id) {
        this.id = id;
    }

    public OrgContacts(Integer id, String cfirstname, String clastname, String cemail) {
        this.id = id;
        this.cfirstname = cfirstname;
        this.clastname = clastname;
        this.cemail = cemail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCfirstname() {
        return cfirstname;
    }

    public void setCfirstname(String cfirstname) {
        this.cfirstname = cfirstname;
    }

    public String getClastname() {
        return clastname;
    }

    public void setClastname(String clastname) {
        this.clastname = clastname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCemail2() {
        return cemail2;
    }

    public void setCemail2(String cemail2) {
        this.cemail2 = cemail2;
    }

    public String getCmobile() {
        return cmobile;
    }

    public void setCmobile(String cmobile) {
        this.cmobile = cmobile;
    }

    public String getCmobile2() {
        return cmobile2;
    }

    public void setCmobile2(String cmobile2) {
        this.cmobile2 = cmobile2;
    }

    public String getCcountry() {
        return ccountry;
    }

    public void setCcountry(String ccountry) {
        this.ccountry = ccountry;
    }

    public Collection<OrgBusiness> getOrgBusinessCollection() {
        return orgBusinessCollection;
    }

    public void setOrgBusinessCollection(Collection<OrgBusiness> orgBusinessCollection) {
        this.orgBusinessCollection = orgBusinessCollection;
    }

    public OrgUsers getOrgUsers() {
        return orgUsers;
    }

    public void setOrgUsers(OrgUsers orgUsers) {
        this.orgUsers = orgUsers;
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
        if (!(object instanceof OrgContacts)) {
            return false;
        }
        OrgContacts other = (OrgContacts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.organizer.db.OrgContacts[ id=" + id + " ]";
    }
    
}
