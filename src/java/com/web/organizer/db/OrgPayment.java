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

/**
 *
 * @author delian
 */
@Entity
@Table(name = "ORG_PAYMENT")
@NamedQueries({
    @NamedQuery(name = "OrgPayment.findAll", query = "SELECT o FROM OrgPayment o"),
    @NamedQuery(name = "OrgPayment.findById", query = "SELECT o FROM OrgPayment o WHERE o.id = :id"),
    @NamedQuery(name = "OrgPayment.findByAmount", query = "SELECT o FROM OrgPayment o WHERE o.amount = :amount"),
    @NamedQuery(name = "OrgPayment.findByComming", query = "SELECT o FROM OrgPayment o WHERE o.comming = :comming"),
    @NamedQuery(name = "OrgPayment.findByFinished", query = "SELECT o FROM OrgPayment o WHERE o.finished = :finished")})
public class OrgPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "COMMING")
    private Serializable comming;
    @Column(name = "FINISHED")
    private Serializable finished;
    @JoinColumn(name = "TASKS_ID", referencedColumnName = "ID")
    @ManyToOne
    private OrgTasks orgTasks;

    public OrgPayment() {
    }

    public OrgPayment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Serializable getComming() {
        return comming;
    }

    public void setComming(Serializable comming) {
        this.comming = comming;
    }

    public Serializable getFinished() {
        return finished;
    }

    public void setFinished(Serializable finished) {
        this.finished = finished;
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
        if (!(object instanceof OrgPayment)) {
            return false;
        }
        OrgPayment other = (OrgPayment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.organizer.db.OrgPayment[ id=" + id + " ]";
    }
    
}
