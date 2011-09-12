/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.data;

/**
 *
 * @author Gery
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Gery
 */
@Entity
public class BusinessPerson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    @Enumerated(EnumType.ORDINAL)
    private String companyName = "";
    private String position = "";
    private String bEmail = "";
    private String bMobile = "";
    private String bMobile2 = "";
    private String fax = "";
    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;

    public BusinessPerson() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getbEmail() {
        return bEmail;
    }

    public void setbEmail(String bEmail) {
        this.bEmail = bEmail;
    }

    public String getbMobile() {
        return bMobile;
    }

    public void setbMobile(String bMobile) {
        this.bMobile = bMobile;
    }

    public String getbMobile2() {
        return bMobile2;
    }

    public void setbMobile2(String bMobile2) {
        this.bMobile2 = bMobile2;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
