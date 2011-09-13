/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author delian
 */
@Entity
@Table(name = "ORG_TASKS")
@NamedQueries({
    @NamedQuery(name = "OrgTasks.findAll", query = "SELECT o FROM OrgTasks o"),
    @NamedQuery(name = "OrgTasks.findById", query = "SELECT o FROM OrgTasks o WHERE o.id = :id"),
    @NamedQuery(name = "OrgTasks.findByStarttime", query = "SELECT o FROM OrgTasks o WHERE o.starttime = :starttime"),
    @NamedQuery(name = "OrgTasks.findByEndtime", query = "SELECT o FROM OrgTasks o WHERE o.endtime = :endtime"),
    @NamedQuery(name = "OrgTasks.findByReocurring", query = "SELECT o FROM OrgTasks o WHERE o.reocurring = :reocurring")})
public class OrgTasks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    @Column(name = "REOCURRING")
    private Integer reocurring;
    @OneToMany(mappedBy = "orgTasks")
    private Collection<OrgEvents> orgEventsCollection;
    @OneToMany(mappedBy = "orgTasks")
    private Collection<OrgPayment> orgPaymentCollection;
    @JoinColumn(name = "NOTES_ID", referencedColumnName = "ID")
    @ManyToOne
    private OrgNotes orgNotes;

    public OrgTasks() {
    }

    public OrgTasks(Integer id) {
        this.id = id;
    }

    public OrgTasks(Integer id, Date starttime, Date endtime) {
        this.id = id;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getReocurring() {
        return reocurring;
    }

    public void setReocurring(Integer reocurring) {
        this.reocurring = reocurring;
    }

    public Collection<OrgEvents> getOrgEventsCollection() {
        return orgEventsCollection;
    }

    public void setOrgEventsCollection(Collection<OrgEvents> orgEventsCollection) {
        this.orgEventsCollection = orgEventsCollection;
    }

    public Collection<OrgPayment> getOrgPaymentCollection() {
        return orgPaymentCollection;
    }

    public void setOrgPaymentCollection(Collection<OrgPayment> orgPaymentCollection) {
        this.orgPaymentCollection = orgPaymentCollection;
    }

    public OrgNotes getOrgNotes() {
        return orgNotes;
    }

    public void setOrgNotes(OrgNotes orgNotes) {
        this.orgNotes = orgNotes;
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
        if (!(object instanceof OrgTasks)) {
            return false;
        }
        OrgTasks other = (OrgTasks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.organizer.db.OrgTasks[ id=" + id + " ]";
    }
    
}
