package com.idb.webservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.webservice.Entities.KhachHangLeadChienDichDataTls;
import com.idb.webservice.JpaRepo.KhachHangLeadChienDichDataTlsRepo;

@Service
public class KhachHangLeadChienDichDataTlsService {
    @Autowired
    private KhachHangLeadChienDichDataTlsRepo repo;

    public List<KhachHangLeadChienDichDataTls> retrieveByFkCD(String fkCD) {
        return repo.findByFkCD(fkCD);
    }

    public List<KhachHangLeadChienDichDataTls> createMulti(List<KhachHangLeadChienDichDataTls> khachHangLeadChienDichDataTlss) {
        List<KhachHangLeadChienDichDataTls> tmps = khachHangLeadChienDichDataTlss;

        for (KhachHangLeadChienDichDataTls item : tmps) {
            item.setId(null);
        }

        List<KhachHangLeadChienDichDataTls> tmpSaved = null;

        try {
            tmpSaved = repo.saveAll(tmps);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmpSaved;
    }
}
