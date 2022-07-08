package com.idb.webservice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idb.webservice.Entities.ProductOrdered;
import com.idb.webservice.JpaRepo.ProductOrderedRepo;

@Service
public class ProductOrderedService {
    @Autowired
    private ProductOrderedRepo repo;

    public List<ProductOrdered> retrieveBySanPhamId(String sanPhamId) {
        return repo.findBySanPham(sanPhamId);
    }

    public List<ProductOrdered> retrieveByTicketId(String ticketId) {
        return repo.findByTicketId(ticketId);
    }
}
