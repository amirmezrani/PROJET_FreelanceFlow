package com.example.proj_profess.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpeciality;

    private String label;

    public Long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Long idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
/* @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Provider> providerList;*/
}
