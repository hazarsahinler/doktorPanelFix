package com.doktor_panel.doktor.Repos;

import com.doktor_panel.doktor.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress,Integer> {


}
