package com.DoktorPaneli.Doktor_Paneli.model;

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
    @JoinColumn(name = "doctor_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Doktor doktorId;

    public IBAN(String IBAN, Doktor doktorId) {
        this.IBAN = IBAN;
        this.doktorId = doktorId;
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

    public Doktor getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(Doktor doktorId) {
        this.doktorId = doktorId;
    }

    @Override
    public String toString() {
        return "IBAN{" +
                "id=" + id +
                ", IBAN='" + IBAN + '\'' +
                ", doktorId=" + doktorId +
                '}';
    }
}


