package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "adres_bilgileri")
public class AdresBilgileri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(name = "adress")
    private String adress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doktor_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
   Doktor doktor;

    public AdresBilgileri(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    @Override
    public String toString() {
        return "AdresBilgileri{" +
                "id=" + id +
                '}';
    }
}





