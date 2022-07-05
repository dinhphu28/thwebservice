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
@Table(name = "app_fd_sp_su_kb_faq")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Faq {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "c_ngay_cap_nhat")
    private String ngayCapNhat;

    @Column(name = "c_hoi")
    private String hoi;

    @Column(name = "c_tra_loi")
    private String traLoi;

    @Column(name = "c_dong_sp")
    private String dongSp;

    @Column(name = "c_mail")
    private String mail;

    @Column(name = "c_trang_thai")
    private String trangThai;
}