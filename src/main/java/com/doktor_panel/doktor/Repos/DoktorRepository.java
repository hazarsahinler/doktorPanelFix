package com.doktor_panel.doktor.Repos;

import com.doktor_panel.doktor.entity.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoktorRepository extends JpaRepository<Doktor,Integer> {


}
