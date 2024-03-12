package com.doktor_panel.doktor.Repos;

import com.doktor_panel.doktor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,String> {

    List<Doctor> findByBranch(String branch);

    List<Doctor> findByLanguages(String languages);
    List<Doctor> findByTitle(String title);
}
