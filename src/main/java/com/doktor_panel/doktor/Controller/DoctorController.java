package com.doktor_panel.doktor.Controller;

import com.doktor_panel.doktor.Repos.DoctorRepository;
import com.doktor_panel.doktor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;
    //get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    //get doctor by branch name
    @GetMapping("branch/{branch}")
    public List<Doctor> getDoctorByBranch(@PathVariable String branch){
        return doctorRepository.findByBranch(branch);
    }
    //get doctors by language
    @GetMapping("/languages/{language}")
    public List<Doctor> getDoctorsByLanguages(@PathVariable String language) {
        List<Doctor> allDoctors = doctorRepository.findAll();
        List<Doctor> doctorsByLanguage = new ArrayList<>();

        for (Doctor doctor : allDoctors) {
            List<String> languages = doctor.getLanguages();
            if (languages != null && languages.contains(language)) {
                doctorsByLanguage.add(doctor);
            }
        }

        return doctorsByLanguage;
    }
    //get doctor by title
    @GetMapping("/title/{title}")
    public List<Doctor> getDoctorsByTitles(@PathVariable String title){
        return doctorRepository.findByTitle(title);
    }


    //add doctor
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor _doctor;
        _doctor = doctorRepository.save(doctor);
        return new ResponseEntity<>(_doctor, HttpStatus.CREATED);
    }




}
