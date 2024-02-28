package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="uzmanlikAlan")
public class Uzmanlik {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="alan_id")
    private int alan_id;

    @Lob
    @Column(name = "isim")
    private String isim;
    //her alanin birden fazla doktoru olabilir...
    @OneToMany(mappedBy = "uzmanlik", cascade = CascadeType.ALL)
    List<Doktor> doktorList;

    public Uzmanlik() {
    }

    public Uzmanlik(String isim) {
        this.isim = isim;

    }

    public int getAlan_id() {
        return alan_id;
    }

    public void setAlan_id(int alan_id) {
        this.alan_id = alan_id;
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
        return "Uzmanlik{" +
                "alan_id=" + alan_id +
                ", isim='" + isim + '\'' +
                ", doktorList=" + doktorList +
                '}';
    }
}
