package com.idb.webservice.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.webservice.Entities.SanPham;

public interface SanPhamRepo extends JpaRepository<SanPham, String> {
    
}
