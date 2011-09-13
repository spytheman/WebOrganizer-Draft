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
@Table(name = "ORG_EVENTS")
@NamedQueries({
    @NamedQuery(name = "OrgEvents.findAll", query = "SELECT o FROM OrgEvents o"),
    @NamedQuery(name = "OrgEvents.findById", query = "SELECT o FROM OrgEvents o WHERE o.id = :id"),
    @NamedQuery(name = "OrgEvents.findByLocation", query = "SELECT o FROM OrgEvents o WHERE o.location = :location")})
public class OrgEvents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 300)
    @Column(name = "LOCATION")
    private String location;
    @JoinColumn(name = "TASKS_ID", referencedColumnName = "ID")
    @ManyToOne
    private OrgTasks orgTasks;

    public OrgEvents() {
    }

    public OrgEvents(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public OrgTasks getOrgTasks() {
        return orgTasks;
    }

    public void setOrgTasks(OrgTasks orgTasks) {
        this.orgTasks = orgTasks;
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
        if (!(object instanceof OrgEvents)) {
            return false;
        }
        OrgEvents other = (OrgEvents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.organizer.db.OrgEvents[ id=" + id + " ]";
    }
    
}
