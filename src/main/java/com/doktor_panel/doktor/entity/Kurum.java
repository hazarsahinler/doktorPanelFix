package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kurum")
public class Kurum {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="kurum_id")
    private int kurum_id;

    @Lob
    @Column(name = "isim")
    private String isim;

    @Lob
    @Column(name="adres")
    private String adres;

    @Lob
    @Column(name="telNo")
    private Long telno;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "kurumList")
    @JsonIgnore
    private List<Doktor> doktorList = new ArrayList<>();

    public Kurum() {
    }

    public Kurum(String isim, String adres, Long telno) {
        this.isim = isim;
        this.adres = adres;
        this.telno = telno;
    }

    public int getKurum_id() {
        return kurum_id;
    }

    public void setKurum_id(int kurum_id) {
        this.kurum_id = kurum_id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Long getTelno() {
        return telno;
    }

    public void setTelno(Long telno) {
        this.telno = telno;
    }

    public List<Doktor> getDoktorList() {
        return doktorList;
    }

    public void setDoktorList(List<Doktor> doktorList) {
        this.doktorList = doktorList;
    }

    @Override
    public String toString() {
        return "Kurum{" +
                "kurum_id=" + kurum_id +
                ", isim='" + isim + '\'' +
                ", adres='" + adres + '\'' +
                ", telno=" + telno +
                ", doktorList=" + doktorList +
                '}';
    }
}
