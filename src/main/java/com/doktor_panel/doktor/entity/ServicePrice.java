package com.doktor_panel.doktor.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "service_price")
public class ServicePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "online_question")
    private int onlineQuestion;

    //online görüşme dk başı ücreti
    @Column(name = "online_meeting")
    private int onlineMeeting;

    //fiziksel görüşme hizmet fiyatı
    @Column(name = "physical_service")
    private int physicalService;
    @OneToMany(mappedBy = "servicePrice", cascade = CascadeType.ALL)
    List<Doctor> doctorList;

    public ServicePrice() {
    }

    public ServicePrice(int onlineQuestion, int onlineMeeting, int physicalService) {
        this.onlineQuestion = onlineQuestion;
        this.onlineMeeting = onlineMeeting;
        this.physicalService = physicalService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOnlineQuestion() {
        return onlineQuestion;
    }

    public void setOnlineQuestion(int onlineQuestion) {
        this.onlineQuestion = onlineQuestion;
    }

    public int getOnlineMeeting() {
        return onlineMeeting;
    }

    public void setOnlineMeeting(int onlineMeeting) {
        this.onlineMeeting = onlineMeeting;
    }

    public int getPhysicalService() {
        return physicalService;
    }

    public void setPhysicalService(int physicalService) {
        this.physicalService = physicalService;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}