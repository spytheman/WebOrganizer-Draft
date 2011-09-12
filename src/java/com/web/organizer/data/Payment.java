/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Geryz
 */
@Entity
public class Payment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    private Double amount ;
    private boolean comming ;
    private boolean finished ;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Task task;

     public Payment(){

}

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isComming() {
        return comming;
    }

    public void setComming(boolean comming) {
        this.comming = comming;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }


}
