package com.idb.webservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.webservice.Entities.SanPham;
import com.idb.webservice.JpaRepo.SanPhamRepo;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepo repo;

    public List<SanPham> retrieveAll() {
        return repo.findAll();
    }

    public SanPham retrieveOneById(String id) {
        SanPham tmp = null;

        try {
            tmp = repo.findById(id).get();
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmp;
    }

    public SanPham createOne(SanPham sanPham) {
        SanPham tmpSanPham = sanPham;

        tmpSanPham.setId(null);

        SanPham tmpSaved = null;

        try {
            tmpSaved = repo.save(tmpSanPham);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return tmpSaved;
    }
}
