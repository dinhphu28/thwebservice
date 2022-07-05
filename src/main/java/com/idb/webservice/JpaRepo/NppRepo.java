package com.idb.webservice.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.webservice.Entities.Npp;

public interface NppRepo extends JpaRepository<Npp, String> {
    
}
