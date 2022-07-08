package com.idb.webservice.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_fd_sp_ticket_dh_csp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrdered {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "c_san_pham")
    private String sanPham;

    @Column(name = "c_so_luong")
    private String soLuong;

    @Column(name = "c_ghi_chu")
    private String ghiChu;

    @Column(name = "c_fk")
    private String ticketId;
}
