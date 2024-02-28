package com.doktor_panel.doktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
@Table(name="doktor")
public class Doktor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="doktor_id")
    private int doktor_id;

    @Column(name="ad")
    private  String ad;
    @Column(name="soyAd")
    private  String soyAd;
    //bir doktorun bir unvanı olabilir.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unvanId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Unvan unvan;

    //hizmet fiyat tablomda 3 değer ve bu 3 değeri verdiği hizmetlere göre
    //fiyatlandırma imkanı yoksa null.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FiyatId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    HizmetFiyat hizmetFiyat;

    //birden fazla doktor aynı alanda çalışıyor olabilir..
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uzmanlikId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Uzmanlik uzmanlik;

    @Lob
    @Column(name="foto")
    private byte[] foto;

    //bir doktor birden fazla kurumda çalışabilir
    // aynı şekilde
    // bir kurum birden fazla doktor çalıştırabilir
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "doktor_kurum",
            joinColumns = { @JoinColumn(name = "doktor_id") },
            inverseJoinColumns = { @JoinColumn(name = "kurum_id") })
    private List<Kurum> kurumList = new ArrayList<>();



    //bir doktor birden fazla dil konuşabilir aynı şekilde bir dili konuşan doktor listesi de olabilir.
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "doktor_dil", joinColumns = { @JoinColumn(name = "doktor_id") }, inverseJoinColumns = { @JoinColumn(name = "dil_id") })
    private List<Dil> dilList = new ArrayList<>();

    @OneToMany(mappedBy = "doktor", cascade = CascadeType.ALL)
    private Set<Biyografi> biyografiSet;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "doktor_hizmet",
            joinColumns = { @JoinColumn(name = "doktor_id") },
            inverseJoinColumns = { @JoinColumn(name = "hizmet_id") })
    private List<Hizmet> hizmetList = new ArrayList<>();
    @OneToMany(mappedBy = "doktor", cascade = CascadeType.ALL)
    List<AdresBilgileri> adresBilgileriList;

    @OneToMany(mappedBy = "doktor", cascade = CascadeType.ALL)
    List<Alınan_Eğitimler> alınanEğitimlerList;

    @OneToMany(mappedBy = "doktor", cascade = CascadeType.ALL)
    List<İş_deneyimi> i̇şDeneyimiList;
    @OneToMany(mappedBy = "doktor", cascade = CascadeType.ALL)
    List<Telefon_Bilgileri> telefonBilgileriList;



    public Doktor() {
    }

    public Doktor(String ad, String soyAd, byte[] foto) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.foto = foto;
    }

    public List<Telefon_Bilgileri> getTelefonBilgileriList() {
        return telefonBilgileriList;
    }

    public void setTelefonBilgileriList(List<Telefon_Bilgileri> telefonBilgileriList) {
        this.telefonBilgileriList = telefonBilgileriList;
    }

    public List<İş_deneyimi> getİşDeneyimiList() {
        return i̇şDeneyimiList;
    }

    public void setİşDeneyimiList(List<İş_deneyimi> i̇şDeneyimiList) {
        this.i̇şDeneyimiList = i̇şDeneyimiList;
    }

    public List<Alınan_Eğitimler> getAlınanEğitimlerList() {
        return alınanEğitimlerList;
    }

    public void setAlınanEğitimlerList(List<Alınan_Eğitimler> alınanEğitimlerList) {
        this.alınanEğitimlerList = alınanEğitimlerList;
    }

    public List<Hizmet> getHizmetList() {
        return hizmetList;
    }

    public void setHizmetList(List<Hizmet> hizmetList) {
        this.hizmetList = hizmetList;
    }

    public List<AdresBilgileri> getAdresBilgileriList() {
        return adresBilgileriList;
    }

    public void setAdresBilgileriList(List<AdresBilgileri> adresBilgileriList) {
        this.adresBilgileriList = adresBilgileriList;
    }

    public int getDoktor_id() {
        return doktor_id;
    }

    public void setDoktor_id(int doktor_id) {
        this.doktor_id = doktor_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    public Unvan getUnvan() {
        return unvan;
    }

    public void setUnvan(Unvan unvan) {
        this.unvan = unvan;
    }

    public Uzmanlik getUzmanlik() {
        return uzmanlik;
    }

    public void setUzmanlik(Uzmanlik uzmanlik) {
        this.uzmanlik = uzmanlik;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public List<Kurum> getKurumList() {
        return kurumList;
    }

    public void setKurumList(List<Kurum> kurumList) {
        this.kurumList = kurumList;
    }

    public List<Dil> getDilList() {
        return dilList;
    }

    public void setDilList(List<Dil> dilList) {
        this.dilList = dilList;
    }

    public Set<Biyografi> getBiyografiSet() {
        return biyografiSet;
    }

    public void setBiyografiSet(Set<Biyografi> biyografiSet) {
        this.biyografiSet = biyografiSet;
    }

    public HizmetFiyat getHizmetFiyat() {
        return hizmetFiyat;
    }

    public void setHizmetFiyat(HizmetFiyat hizmetFiyat) {
        this.hizmetFiyat = hizmetFiyat;
    }


}
