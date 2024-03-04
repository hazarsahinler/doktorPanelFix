package com.doktor_panel.doktor.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "title")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="title_id")
    private Integer titleId;

    @Lob
    @Column(name = "title_name")
    private String titleName;

    //bir unvandan birden fazla olabilir..
    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL)
    List<Doctor> doctorList;

    public Title() {
    }

    public Title(String titleName) {
        this.titleName = titleName;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
