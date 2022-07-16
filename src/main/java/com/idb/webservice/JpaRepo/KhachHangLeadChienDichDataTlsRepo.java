package com.idb.webservice.JpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idb.webservice.Entities.KhachHangLeadChienDichDataTls;

@Repository
public interface KhachHangLeadChienDichDataTlsRepo extends JpaRepository<KhachHangLeadChienDichDataTls, String> {
    List<KhachHangLeadChienDichDataTls> findByFkCD(String fkCD);
}
