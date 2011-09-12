/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Gery
 */
@Entity
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title = "";
    private String description = "";
    @ManyToMany
    private Collection<Person> person;

    public Note() {
        person = new ArrayList<Person>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
