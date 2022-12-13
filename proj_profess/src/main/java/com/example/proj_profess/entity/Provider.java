package com.example.proj_profess.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Provider extends User{



    private String firstName;

    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(name = "phone", nullable = false,unique = true)
    private int phone;

    @Column(columnDefinition="TEXT")
    private String description;

    private String street;

    private String longitude;

    private String latitude;

    private double feed;
    @JsonIgnore
    private int numbFeed;

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

    public double getFeed() {
        return feed;
    }

    public void setFeed(double feed) {
        this.feed = feed;
    }

    public int getNumbFeed() {
        return numbFeed;
    }

    public void setNumbFeed(int numbFeed) {
        this.numbFeed = numbFeed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
