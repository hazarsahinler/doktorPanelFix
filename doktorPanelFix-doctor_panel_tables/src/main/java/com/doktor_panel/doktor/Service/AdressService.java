package com.doktor_panel.doktor.Service;

import com.doktor_panel.doktor.entity.Adress;

import java.util.List;

public interface AdressService {
    List<Adress> getAllAdress();
    Adress getAdressById(Integer id);
    Adress saveAdress(Adress adress);
    void deleteAdress(Integer id);
}
