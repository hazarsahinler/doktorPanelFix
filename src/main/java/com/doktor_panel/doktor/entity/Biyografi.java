package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="biyografi")
public class Biyografi {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="biyo_id")
    private int biyo_id;

    @Lob
    @Column(name = "content")
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doktor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Doktor doktor;

    public Biyografi() {
    }

    public Biyografi(String content) {
        this.content = content;
    }

    public int getBiyo_id() {
        return biyo_id;
    }

    public void setBiyo_id(int biyo_id) {
        this.biyo_id = biyo_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    @Override
    public String toString() {
        return "Biyografi{" +
                "biyo_id=" + biyo_id +
                ", content='" + content + '\'' +
                ", doktor=" + doktor +
                '}';
    }
}

