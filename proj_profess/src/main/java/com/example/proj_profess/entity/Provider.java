package com.example.proj_profess.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Provider extends User{



    private String firstName;

    private String lastName;

    private Date birthday;

    @Column(name = "phone", nullable = false,unique = true)
    private int phone;

    private String street;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCity",nullable = false)
    private City city;

    //@OneToMany(fetch = FetchType.LAZY)
    //List<Contract> contractList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSpeciality",nullable = false)
    private Speciality speciality;

   // @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   // @JoinColumn(name = "idJob")
          //  @JsonIgnore
    //Set<Job> jobList=new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }


}