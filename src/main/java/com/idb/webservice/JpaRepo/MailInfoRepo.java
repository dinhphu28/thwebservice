package com.idb.webservice.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.webservice.Entities.MailInfo;

public interface MailInfoRepo extends JpaRepository<MailInfo, String> {
    
}
