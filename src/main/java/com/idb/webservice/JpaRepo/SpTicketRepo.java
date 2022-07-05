package com.idb.webservice.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idb.webservice.Entities.SpTicket;

@Repository
public interface SpTicketRepo extends JpaRepository<SpTicket, String> {
    
}
