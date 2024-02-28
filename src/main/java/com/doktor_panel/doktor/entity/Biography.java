package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="biography")
public class Biography {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="bio_id")
    private int bioId;

    @Lob
    @Column(name = "bio_content")
    private String bioContent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Doctor doctor;

    public Biography() {
    }

    public Biography(String bioContent) {
        this.bioContent = bioContent;
    }

    public int getBioId() {
        return bioId;
    }

    public void setBioId(int bioId) {
        this.bioId = bioId;
    }

    public String getBioContent() {
        return bioContent;
    }

    public void setBioContent(String bioContent) {
        this.bioContent = bioContent;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

