package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unvan")
public class Unvan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="unvan_id")
    private Integer unvan_id;

    @Lob
    @Column(name = "isim")
    private String isim;

    //bir unvandan birden fazla olabilir..
    @OneToMany(mappedBy = "unvan", cascade = CascadeType.ALL)
    List<Doktor> doktorList;

    public Unvan() {
    }

    public Unvan(String isim) {
        this.isim = isim;
    }

    public Integer getUnvan_id() {
        return unvan_id;
    }

    public void setUnvan_id(Integer unvan_id) {
        this.unvan_id = unvan_id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public List<Doktor> getDoktorList() {
        return doktorList;
    }

    public void setDoktorList(List<Doktor> doktorList) {
        this.doktorList = doktorList;
    }

    @Override
    public String toString() {
        return "Unvan{" +
                "unvan_id=" + unvan_id +
                ", isim='" + isim + '\'' +
                ", doktorList=" + doktorList +
                '}';
    }
}
