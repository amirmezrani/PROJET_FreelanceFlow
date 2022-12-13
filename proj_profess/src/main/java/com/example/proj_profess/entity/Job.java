package com.example.proj_profess.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJob;

    private String title;

    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProvider")
    @JsonIgnore
    private Provider provider;


    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
