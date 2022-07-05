package com.idb.webservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.webservice.Entities.Ths;
import com.idb.webservice.JpaRepo.ThsRepo;

@Service
public class ThsService {
    @Autowired
    private ThsRepo repo;

    public List<Ths> retrieveAll() {
        return repo.findAll();
    }

    public Ths retrieveOneById(String id) {
        Ths tmp = null;

        try {
            tmp = repo.findById(id).get();
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmp;
    }

    public Ths createOne(Ths ths) {
        Ths tmpThs = ths;

        tmpThs.setId(null);

        Ths tmpToSaved = null;

        try {
            tmpToSaved = repo.save(tmpThs);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmpToSaved;
    }
}
