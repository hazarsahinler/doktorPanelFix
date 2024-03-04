package com.doktor_panel.doktor.ServiceImpl;

import com.doktor_panel.doktor.Repos.AdressRepository;
import com.doktor_panel.doktor.Service.AdressService;
import com.doktor_panel.doktor.entity.Adress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressServiceImpl implements AdressService {

    private  AdressRepository adressRepository;
    public AdressServiceImpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;

    }
    @Override
    public List<Adress> getAllAdress() {
        return adressRepository.findAll();
    }

    @Override
    public Adress getAdressById(Integer id) {
        return adressRepository.findById(id).orElse(null);
    }

    @Override
    public Adress saveAdress(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public void deleteAdress(Integer id) {
        adressRepository.deleteById(id);

    }
}
