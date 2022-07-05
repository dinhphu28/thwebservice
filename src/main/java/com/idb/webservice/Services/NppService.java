package com.idb.webservice.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.webservice.Entities.Npp;
import com.idb.webservice.JpaRepo.NppRepo;

@Service
public class NppService {
    @Autowired
    private NppRepo repo;

    public List<Npp> retrieveAll() {
        return repo.findAll();
    }

    public Npp retrieveOneById(String id) {
        Npp tmp = null;

        try {
            tmp = repo.findById(id).get();
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmp;
    }

    public Npp createOne(Npp npp) {
        Npp tmpNpp = npp;

        tmpNpp.setId(null);

        Npp tmpSaved = null;

        try {
            tmpSaved = repo.save(tmpNpp);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmpSaved;
    }

    public List<Npp> createMulti(List<Npp> npps) {
        List<Npp> tmpNpps = npps;

        for (Npp npp : tmpNpps) {
            npp.setId(null);
        }

        List<Npp> tmpsSaved = null;

        try {
            tmpsSaved = repo.saveAll(tmpNpps);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmpsSaved;
    }
}
