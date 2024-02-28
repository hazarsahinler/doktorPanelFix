package com.DoktorPaneli.Doktor_Paneli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Telefon_Bilgileri")
public class Telefon_Bilgileri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "telefon")
    private String telefon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Doktor doktorId;

    public Telefon_Bilgileri(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Doktor getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(Doktor doktorId) {
        this.doktorId = doktorId;
    }

    @Override
    public String toString() {
        return "Telefon_Bilgileri{" +
                "id=" + id +
                ", telefon='" + telefon + '\'' +
                ", doktorId=" + doktorId +
                '}';
    }
}
