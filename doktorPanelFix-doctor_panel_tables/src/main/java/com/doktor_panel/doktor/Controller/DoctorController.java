package com.doktor_panel.doktor.Controller;

import com.doktor_panel.doktor.Service.DoktorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    DoktorService doktorService;



}
