package com.doktor_panel.doktor.Service;

import com.doktor_panel.doktor.Repos.DoktorRepository;
import com.doktor_panel.doktor.entity.Doktor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DoktorService {
    @Autowired
    DoktorRepository doktorRepository;



}
