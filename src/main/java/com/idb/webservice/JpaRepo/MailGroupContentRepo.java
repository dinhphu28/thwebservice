package com.idb.webservice.JpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idb.webservice.Entities.MailGroupContent;

@Repository
public interface MailGroupContentRepo extends JpaRepository<MailGroupContent, String> {
    List<MailGroupContent> findByGroupId(String groupId);
}
