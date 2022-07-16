package com.idb.webservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.webservice.Entities.MailInfo;
import com.idb.webservice.JpaRepo.MailInfoRepo;

@Service
public class MailInfoService {
    @Autowired
    private MailInfoRepo repo;

    public List<MailInfo> retrieveBatchMailByIds(List<String> ids) {
        return repo.findAllById(ids);
    }
}
