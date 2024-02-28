package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hizmet")
public class Hizmet {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="hizmet_ismi")
    private String hizmet_ismi;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "hizmetList")
    @JsonIgnore
    private List<Doktor> doktorList = new ArrayList<>();

    public Hizmet() {
    }

    public Hizmet(String hizmet_ismi) {
        this.hizmet_ismi = hizmet_ismi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHizmet_ismi() {
        return hizmet_ismi;
    }

    public void setHizmet_ismi(String hizmet_ismi) {
        this.hizmet_ismi = hizmet_ismi;
    }

    public List<Doktor> getDoktorList() {
        return doktorList;
    }

    public void setDoktorList(List<Doktor> doktorList) {
        this.doktorList = doktorList;
    }
}
