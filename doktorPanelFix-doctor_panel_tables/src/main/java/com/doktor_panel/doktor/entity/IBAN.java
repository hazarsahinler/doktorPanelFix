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
    @Column(name="iban_id")
    private int ibanId;

    @Column(name = "IBAN")
    private String IBAN;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Doctor doctor;

    public IBAN(String IBAN) {
        this.IBAN = IBAN;

    }

    public int getIbanId() {
        return ibanId;
    }

    public void setIbanId(int ibanId) {
        this.ibanId = ibanId;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}


