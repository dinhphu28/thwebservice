package com.idb.webservice.Entities;

import java.time.LocalDateTime;

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
@Table(name = "app_fd_tls_chiendich_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangLeadChienDichDataTls {
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

    @Column(name = "c_fkkh")
    private String fkKH;

    @Column(name = "c_stt")
    private String stt;

    @Column(name = "datecreated")
    private LocalDateTime dateCreated;

    @Column(name = "datemodified")
    private LocalDateTime dateModified;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createdbyname")
    private String createdByName;

    @Column(name = "modifiedby")
    private String modifiedBy;

    @Column(name = "modifiedbyname")
    private String modifiedByName;
}
