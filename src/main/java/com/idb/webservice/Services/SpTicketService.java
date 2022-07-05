package com.idb.webservice.Services;

import com.idb.webservice.Entities.SpTicket;
import com.idb.webservice.JpaRepo.SpTicketRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SpTicketService {
    @Autowired
    private SpTicketRepo repo;

    public SpTicket retrieveById(String id) {
        SpTicket sth = null;

        try {
            sth = repo.findById(id).get();
        } catch (Exception e) {
            //TODO: handle exception
        }

        return sth;
    }

    public List<SpTicket> retrieveAll() {
        return repo.findAll();
    }

    public SpTicket updateOne(SpTicket spTicket) {

        SpTicket tmp = null;

        try {
            tmp = repo.findById(spTicket.getId()).get();

            repo.save(spTicket);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmp;
    }
}
