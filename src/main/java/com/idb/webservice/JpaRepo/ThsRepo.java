package com.idb.webservice.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.webservice.Entities.Ths;

public interface ThsRepo extends JpaRepository<Ths, String> {
    
}
