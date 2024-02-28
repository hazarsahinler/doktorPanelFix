package com.doktor_panel.doktor.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fiyat")
public class HizmetFiyat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="soru")
    private int soru;

    //online görüşme dk başı ücreti
    @Column(name="online")
    private int online;

    //fiziksel görüşme hizmet fiyatı
    @Column(name="fiziksel")
    private int fiziksel;
    @OneToMany(mappedBy = "hizmetFiyat", cascade = CascadeType.ALL)
    List<Doktor> doktorList;

    public HizmetFiyat() {
    }

    public HizmetFiyat(int soru, int online, int fiziksel) {
        this.soru = soru;
        this.online = online;
        this.fiziksel = fiziksel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoru() {
        return soru;
    }

    public void setSoru(int soru) {
        this.soru = soru;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getFiziksel() {
        return fiziksel;
    }

    public void setFiziksel(int fiziksel) {
        this.fiziksel = fiziksel;
    }

    public List<Doktor> getDoktorList() {
        return doktorList;
    }

    public void setDoktorList(List<Doktor> doktorList) {
        this.doktorList = doktorList;
    }
}
