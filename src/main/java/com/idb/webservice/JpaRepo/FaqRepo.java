package com.idb.webservice.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.webservice.Entities.Faq;

public interface FaqRepo extends JpaRepository<Faq, String> {
    
}
