package com.DoktorPaneli.Doktor_Paneli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "İş_Deneyimi")
public class İş_deneyimi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Lob
    @Column(name = "Yaz")
    private String yaz2;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date başlangıç_tarihi2;

    @JsonFormat(pattern="yyyy-MM-dd ")
    private Date bitiş_tarihi2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Doktor doktorId;


    public İş_deneyimi(){

    }

    public İş_deneyimi(String yaz2, Date başlangıç_tarihi2, Date bitiş_tarihi2) {
        this.yaz2 = yaz2;
        this.başlangıç_tarihi2 = başlangıç_tarihi2;
        this.bitiş_tarihi2 = bitiş_tarihi2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYaz2() {
        return yaz2;
    }

    public void setYaz2(String yaz2) {
        this.yaz2 = yaz2;
    }

    public Date getBaşlangıç_tarihi2() {
        return başlangıç_tarihi2;
    }

    public void setBaşlangıç_tarihi2(Date başlangıç_tarihi2) {
        this.başlangıç_tarihi2 = başlangıç_tarihi2;
    }

    public Date getBitiş_tarihi2() {
        return bitiş_tarihi2;
    }

    public void setBitiş_tarihi2(Date bitiş_tarihi2) {
        this.bitiş_tarihi2 = bitiş_tarihi2;
    }

    @Override
    public String toString() {
        return "İş_deneyimi{" +
                "id=" + id +
                ", yaz2='" + yaz2 + '\'' +
                ", başlangıç_tarihi2=" + başlangıç_tarihi2 +
                ", bitiş_tarihi2=" + bitiş_tarihi2 +
                '}';
    }
}
