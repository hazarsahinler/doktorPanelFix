package com.doktor_panel.doktor.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="branch")
public class Branch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="branch_id")
    private int branchId;

    @Lob
    @Column(name = "branch_name")
    private String branchName;
    //her alanin birden fazla doktoru olabilir...
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    List<Doctor> doctorList;

    public Branch() {
    }

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
