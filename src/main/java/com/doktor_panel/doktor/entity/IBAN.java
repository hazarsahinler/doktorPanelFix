package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "IBAN")
public class IBAN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "IBAN")
    private String IBAN;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doktor_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Doktor doktor;

    public IBAN(String IBAN) {
        this.IBAN = IBAN;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    @Override
    public String toString() {
        return "IBAN{" +
                "id=" + id +
                ", IBAN='" + IBAN + '\'' +

                '}';
    }
}


