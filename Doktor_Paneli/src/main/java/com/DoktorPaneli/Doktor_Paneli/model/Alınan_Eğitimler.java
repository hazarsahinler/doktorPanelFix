package com.DoktorPaneli.Doktor_Paneli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "Alınan_Eğitimler")
public class Alınan_Eğitimler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Lob
    @Column(name = "Yaz")
    private String yaz;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date başlangıç_tarihi;

    @JsonFormat(pattern="yyyy-MM-dd ")
    private Date bitiş_tarihi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Doktor doktorId;

    public Alınan_Eğitimler(){

    }

    public Alınan_Eğitimler(String yaz, Date başlangıç_tarihi, Date bitiş_tarihi) {
        this.yaz = yaz;
        this.başlangıç_tarihi = başlangıç_tarihi;
        this.bitiş_tarihi = bitiş_tarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYaz() {
        return yaz;
    }

    public void setYaz(String yaz) {
        this.yaz = yaz;
    }

    public Date getBaşlangıç_tarihi() {
        return başlangıç_tarihi;
    }

    public void setBaşlangıç_tarihi(Date başlangıç_tarihi) {
        this.başlangıç_tarihi = başlangıç_tarihi;
    }

    public Date getBitiş_tarihi() {
        return bitiş_tarihi;
    }

    public void setBitiş_tarihi(Date bitiş_tarihi) {
        this.bitiş_tarihi = bitiş_tarihi;
    }

    @Override
    public String toString() {
        return "Alınan_Eğitimler{" +
                "id=" + id +
                ", yaz='" + yaz + '\'' +
                ", başlangıç_tarihi=" + başlangıç_tarihi +
                ", bitiş_tarihi=" + bitiş_tarihi +
                '}';
    }
}
