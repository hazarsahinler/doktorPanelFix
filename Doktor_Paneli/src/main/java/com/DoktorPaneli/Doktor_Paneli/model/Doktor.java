package com.DoktorPaneli.Doktor_Paneli.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Doktor")
public class Doktor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "doktorId", cascade = CascadeType.ALL)
    List<AdresBilgileri> adresBilgileris;

    @OneToMany(mappedBy = "doktorId", cascade = CascadeType.ALL)
    List<IBAN> IBANS;

    @OneToMany(mappedBy = "doktorId", cascade = CascadeType.ALL)
    List<Telefon_Bilgileri> Telefon;

    @OneToMany(mappedBy = "doktorId", cascade = CascadeType.ALL)
    List<İş_deneyimi> i̇şDeneyimis;

    @OneToMany(mappedBy = "doktorId", cascade = CascadeType.ALL)
    List<Alınan_Eğitimler> alınanEğitimlers;

    public Doktor(){

    }

    public Doktor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AdresBilgileri> getAdresBilgileris() {
        return adresBilgileris;
    }

    public void setAdresBilgileris(List<AdresBilgileri> adresBilgileris) {
        this.adresBilgileris = adresBilgileris;
    }

    public List<Telefon_Bilgileri> getTelefon() {
        return Telefon;
    }

    public void setTelefon(List<Telefon_Bilgileri> telefon) {
        Telefon = telefon;
    }

    @Override
    public String toString() {
        return "Doktor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adresBilgileris=" + adresBilgileris +
                ", Telefon=" + Telefon +
                '}';
    }
}

