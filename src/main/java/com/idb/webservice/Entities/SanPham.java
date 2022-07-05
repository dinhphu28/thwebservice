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
@Table(name = "app_fd_sp_su_kb_san_pham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "c_dong_sp")
    private String dongSp;

    @Column(name = "c_the_tich")
    private String theTich;

    @Column(name = "c_tenn_sp")
    private String tenSp;

    @Column(name = "c_so_hop")
    private String soHop;

    @Column(name = "c_bao_gia")
    private String baoGia;

    @Column(name = "c_hsd")
    private String hsd;

    @Column(name = "c_bao_quan")
    private String baoQuan;

    @Column(name = "c_trang_thai")
    private String trangThai;
}
