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
@Table(name = "app_fd_sp_khachhang_lead")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangLead {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "c_ten")
    private String ten;

    @Column(name = "c_phone")
    private String phone;

    @Column(name = "c_phone2")
    private String phone2;

    @Column(name = "c_so_the")
    private String soThe;

    @Column(name = "c_email")
    private String email;

    @Column(name = "c_dia_chi")
    private String diaChi;

    @Column(name = "c_facebook")
    private String facebook;

    @Column(name = "c_zalo")
    private String zalo;

    @Column(name = "c_gioitinh")
    private String gioiTinh;

    @Column(name = "c_fkcd")
    private String fkCD;

    @Column(name = "c_ngay_sinh")
    private String ngaySinh;

    @Column(name = "c_thanh_pho")
    private String thanhPho;

    @Column(name = "c_quan_huyen")
    private String quanHuyen;

    @Column(name = "c_phuong_xa")
    private String phuongXa;

    @Column(name = "c_ghi_chu")
    private String ghiChu;
}

// id, c_ten, c_Phone, c_Phone2, c_so_the, c_email, c_dia_chi, c_facebook, c_zalo, c_GioiTinh, c_fkCD, c_ngay_sinh