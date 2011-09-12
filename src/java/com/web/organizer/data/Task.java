/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;

/**
 *
 * @author Gery
 */
@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endTime;
    private int reocurring;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Note note;


    public Task() {
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public int getReocurring() {
        return reocurring;
    }

    public void setReocurring(int reocurring) {
        this.reocurring = reocurring;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
