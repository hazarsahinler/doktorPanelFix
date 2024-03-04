package com.doktor_panel.doktor.Controller;

import com.doktor_panel.doktor.Repos.AdressRepository;
import com.doktor_panel.doktor.Service.AdressService;
import com.doktor_panel.doktor.entity.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adress")
public class AdressController {

    private  AdressService adressService;

    public AdressController(AdressService adressService) {
        this.adressService = adressService;
    }


    @GetMapping
    public List<Adress> getAllAdress() {
        return adressService.getAllAdress();
    }

    @GetMapping("/{id}")
    public Adress getAdressById(@PathVariable Integer id) {
        return adressService.getAdressById(id);
    }

    @PostMapping("/{post}")
    public Adress saveAdress(@RequestBody Adress adress) {
        return adressService.saveAdress(adress);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        adressService.deleteAdress(id);
    }



}
