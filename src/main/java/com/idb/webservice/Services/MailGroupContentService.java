package com.idb.webservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.webservice.Entities.MailGroupContent;
import com.idb.webservice.JpaRepo.MailGroupContentRepo;

@Service
public class MailGroupContentService {
    @Autowired
    private MailGroupContentRepo repo;

    public List<MailGroupContent> retriveAll() {
        return repo.findAll();
    }

    public List<MailGroupContent> retrieveByGroupId(String groupId) {
        return repo.findByGroupId(groupId);
    }
}
