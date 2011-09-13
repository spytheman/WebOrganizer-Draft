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
@Table(name = "ORG_NOTES")
@NamedQueries({
    @NamedQuery(name = "OrgNotes.findAll", query = "SELECT o FROM OrgNotes o"),
    @NamedQuery(name = "OrgNotes.findById", query = "SELECT o FROM OrgNotes o WHERE o.id = :id"),
    @NamedQuery(name = "OrgNotes.findByTitle", query = "SELECT o FROM OrgNotes o WHERE o.title = :title"),
    @NamedQuery(name = "OrgNotes.findByDescription", query = "SELECT o FROM OrgNotes o WHERE o.description = :description")})
public class OrgNotes implements Serializable {
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
    @Column(name = "TITLE")
    private String title;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "orgNotes")
    private Collection<OrgTasks> orgTasksCollection;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private OrgUsers orgUsers;

    public OrgNotes() {
    }

    public OrgNotes(Integer id) {
        this.id = id;
    }

    public OrgNotes(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<OrgTasks> getOrgTasksCollection() {
        return orgTasksCollection;
    }

    public void setOrgTasksCollection(Collection<OrgTasks> orgTasksCollection) {
        this.orgTasksCollection = orgTasksCollection;
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
        if (!(object instanceof OrgNotes)) {
            return false;
        }
        OrgNotes other = (OrgNotes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.organizer.db.OrgNotes[ id=" + id + " ]";
    }
    
}
