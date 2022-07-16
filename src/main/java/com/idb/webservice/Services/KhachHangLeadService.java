package com.idb.webservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.webservice.Entities.KhachHangLead;
import com.idb.webservice.JpaRepo.KhachHangLeadRepo;

@Service
public class KhachHangLeadService {
    @Autowired
    private KhachHangLeadRepo repo;

    public List<KhachHangLead> retrieveByMyFilters(String ten, String phone, String phone2, String soThe, String email, String diaChi, String facebook, String zalo, String gioiTinh, String thanhPho, String quanHuyen, String phuongXa, String birthdayFrom, String birthdayTo) {
        return repo.findByMyFilters(ten, phone, phone2, soThe, email, diaChi, facebook, zalo, gioiTinh, thanhPho, quanHuyen, phuongXa, birthdayFrom, birthdayTo);
    }

    // public List<KhachHangLead> retrieveByMyFilters(String ten) {
    //     return repo.findByMyFilters(ten);
    // }
}
