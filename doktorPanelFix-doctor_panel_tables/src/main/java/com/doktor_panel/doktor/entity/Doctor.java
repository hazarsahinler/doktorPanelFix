package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
@Table(name="doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private int doctor_id;


    @Column(name="first_name")
    private  String firstName;
    @Column(name="last_name")
    private  String lastName;
    //bir doktorun bir unvanı olabilir.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Title title;

    //hizmet fiyat tablomda 3 değer ve bu 3 değeri verdiği hizmetlere göre
    //fiyatlandırma imkanı yoksa null.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_info",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    ServicePrice servicePrice;

    //birden fazla doctor aynı alanda çalışıyor olabilir..
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Branch branch;

    @Lob
    @Column(name="photo")
    private byte[] photo;





    //bir doctor birden fazla dil konuşabilir aynı şekilde bir dili konuşan doctor listesi de olabilir.
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "doctor_language", joinColumns = { @JoinColumn(name = "doctor_id") },
            inverseJoinColumns = { @JoinColumn(name = "language_id") })
    private List<Language> languageList = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<Biography> biographySet;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "doktor_service",
            joinColumns = { @JoinColumn(name = "doktor_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") })
    private List<Service> serviceList = new ArrayList<>();
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<Adress> adressList;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<Education> educationList;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<WorkExperience> workExperienceList;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<Phone> phoneList;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "doctor_iban",
            joinColumns = { @JoinColumn(name = "doctor_id") },
            inverseJoinColumns = { @JoinColumn(name = "iban_id") })
    private List<IBAN> ibanList = new ArrayList<>();



    public Doctor() {
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public ServicePrice getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(ServicePrice servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }



    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public Set<Biography> getBiographySet() {
        return biographySet;
    }

    public void setBiographySet(Set<Biography> biographySet) {
        this.biographySet = biographySet;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Adress> getAdressList() {
        return adressList;
    }

    public void setAdressList(List<Adress> adressList) {
        this.adressList = adressList;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public List<IBAN> getIbanList() {
        return ibanList;
    }

    public void setIbanList(List<IBAN> ibanList) {
        this.ibanList = ibanList;
    }
}



