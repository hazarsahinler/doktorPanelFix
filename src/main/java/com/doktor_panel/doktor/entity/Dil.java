package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dil")
public class Dil {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="dil_id")
    private int dil_id;

    @Lob
    @Column(name = "isim")
    private String isim;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "dilList")
    @JsonIgnore
    private List<Doktor> doktorList = new ArrayList<>();

    public Dil() {
    }

    public Dil(String isim) {
        this.isim = isim;
    }

    public int getDil_id() {
        return dil_id;
    }

    public void setDil_id(int dil_id) {
        this.dil_id = dil_id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public List<Doktor> getDoktorList() {
        return doktorList;
    }

    public void setDoktorList(List<Doktor> doktorList) {
        this.doktorList = doktorList;
    }

    @Override
    public String toString() {
        return "Dil{" +
                "dil_id=" + dil_id +
                ", isim='" + isim + '\'' +
                '}';
    }
}
