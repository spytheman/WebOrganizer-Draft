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
@Table(name = "ORG_USERS")
@NamedQueries({
    @NamedQuery(name = "OrgUsers.findAll", query = "SELECT o FROM OrgUsers o"),
    @NamedQuery(name = "OrgUsers.findById", query = "SELECT o FROM OrgUsers o WHERE o.id = :id"),
    @NamedQuery(name = "OrgUsers.findByFirstname", query = "SELECT o FROM OrgUsers o WHERE o.firstname = :firstname"),
    @NamedQuery(name = "OrgUsers.findByLastname", query = "SELECT o FROM OrgUsers o WHERE o.lastname = :lastname"),
    @NamedQuery(name = "OrgUsers.findByEmail", query = "SELECT o FROM OrgUsers o WHERE o.email = :email"),
    @NamedQuery(name = "OrgUsers.findByUsername", query = "SELECT o FROM OrgUsers o WHERE o.username = :username"),
    @NamedQuery(name = "OrgUsers.findByEmail2", query = "SELECT o FROM OrgUsers o WHERE o.email2 = :email2"),
    @NamedQuery(name = "OrgUsers.findByPassword", query = "SELECT o FROM OrgUsers o WHERE o.password = :password"),
    @NamedQuery(name = "OrgUsers.findByMobile", query = "SELECT o FROM OrgUsers o WHERE o.mobile = :mobile"),
    @NamedQuery(name = "OrgUsers.findByMobile2", query = "SELECT o FROM OrgUsers o WHERE o.mobile2 = :mobile2"),
    @NamedQuery(name = "OrgUsers.findByTimezone", query = "SELECT o FROM OrgUsers o WHERE o.timezone = :timezone"),
    @NamedQuery(name = "OrgUsers.findByCountry", query = "SELECT o FROM OrgUsers o WHERE o.country = :country")})
public class OrgUsers implements Serializable {
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
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 30)
    @Column(name = "EMAIL2")
    private String email2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 30)
    @Column(name = "MOBILE")
    private String mobile;
    @Size(max = 30)
    @Column(name = "MOBILE2")
    private String mobile2;
    @Size(max = 30)
    @Column(name = "TIMEZONE")
    private String timezone;
    @Size(max = 30)
    @Column(name = "COUNTRY")
    private String country;
    @OneToMany(mappedBy = "orgUsers")
    private Collection<OrgContacts> orgContactsCollection;
    @OneToMany(mappedBy = "orgUsers")
    private Collection<OrgNotes> orgNotesCollection;

    public OrgUsers() {
    }

    public OrgUsers(Integer id) {
        this.id = id;
    }

    public OrgUsers(Integer id, String firstname, String lastname, String email, String username, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Collection<OrgContacts> getOrgContactsCollection() {
        return orgContactsCollection;
    }

    public void setOrgContactsCollection(Collection<OrgContacts> orgContactsCollection) {
        this.orgContactsCollection = orgContactsCollection;
    }

    public Collection<OrgNotes> getOrgNotesCollection() {
        return orgNotesCollection;
    }

    public void setOrgNotesCollection(Collection<OrgNotes> orgNotesCollection) {
        this.orgNotesCollection = orgNotesCollection;
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
        if (!(object instanceof OrgUsers)) {
            return false;
        }
        OrgUsers other = (OrgUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.organizer.db.OrgUsers[ id=" + id + " ]";
    }
    
}
