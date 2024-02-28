package com.doktor_panel.doktor.Service;

import com.doktor_panel.doktor.Repos.DoktorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoktorService {
    @Autowired
    DoktorRepository doktorRepository;



}
