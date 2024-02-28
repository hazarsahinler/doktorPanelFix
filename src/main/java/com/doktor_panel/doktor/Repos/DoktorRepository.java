package com.doktor_panel.doktor.Repos;

import com.doktor_panel.doktor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoktorRepository extends JpaRepository<Doctor,Integer> {


}
