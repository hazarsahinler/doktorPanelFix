package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
@Table(name="doctor")
@Data
public class Doctor {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String firstName;
    private String lastName;
    private String title;
    private String branch;
    private String specialization;
    @ElementCollection
    private List<String> languages;
    @Lob
    private String biography;
    @Lob
    private String Diseases;
    @Lob
    private String  Institutions;
    @Lob
    private String iban_acc_holder;
    @Lob
    private String iban;
    private int physicalInterviewPrice;
    private int onlineInterviewPrice;
    private int onlineTime;
    private int onlineQuestionPrice;



}



