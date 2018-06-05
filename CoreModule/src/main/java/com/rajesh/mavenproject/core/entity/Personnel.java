/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.mavenproject.core.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "personnels")
public class Personnel implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String enmail;

    @Column(name = "contact_no")
    private String contact_no;

    @Column(name = "adddedDate", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date adddedDate;

    @Column(name = "modifiedDate", nullable = true)
    private Date modifiedDate;

    @Column(name = "status")
    private Boolean status;

    public Personnel(int id, String first_name, String last_name, String enmail, String contact_no, Boolean status) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.enmail = enmail;
        this.contact_no = contact_no;
        this.status = status;
    }

    public Personnel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEnmail() {
        return enmail;
    }

    public void setEnmail(String enmail) {
        this.enmail = enmail;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public Date getAdddedDate() {
        return adddedDate;
    }

    public void setAdddedDate(Date adddedDate) {
        this.adddedDate = adddedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
