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
@Table(name = "app_fd_sp_su_kb_npp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Npp {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "c_kenh")
    private String kenh;

    @Column(name = "c_mien")
    private String mien;

    @Column(name = "c_tinh_thanh")
    private String tinhThanh;

    @Column(name = "c_quan_huyen")
    private String quanHuyen;

    @Column(name = "c_ten_rut_gon")
    private String tenRutGon;

    @Column(name = "c_giam_sat_01_ten")
    private String giamSat01Ten;

    @Column(name = "c_giam_sat_01_sdt")
    private String giamSat02Sdt;

    @Column(name = "c_ten_asm")
    private String tenAsm;

    @Column(name = "c_dt_asm")
    private String dtAsm;

    @Column(name = "c_ten_sm")
    private String tenSm;

    @Column(name = "c_dt_sm")
    private String dtSm;

    @Column(name = "c_trang_thai")
    private String trangThai;
}