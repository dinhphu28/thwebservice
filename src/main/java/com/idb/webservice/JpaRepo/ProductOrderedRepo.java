package com.idb.webservice.JpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.webservice.Entities.ProductOrdered;

public interface ProductOrderedRepo extends JpaRepository<ProductOrdered, String> {
    List<ProductOrdered> findBySanPham(String sanPham);
    List<ProductOrdered> findByTicketId(String ticketId);
}
