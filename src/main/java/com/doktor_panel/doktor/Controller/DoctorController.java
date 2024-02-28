package com.doktor_panel.doktor.Controller;

import com.doktor_panel.doktor.Service.DoktorService;
import com.doktor_panel.doktor.entity.Doktor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    DoktorService doktorService;



}
