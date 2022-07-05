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
@Table(name = "app_fd_sp_su_kb_ths")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ths {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "c_tp_tinh")
    private String tpTinh;

    @Column(name = "c_quan")
    private String quan;

    @Column(name = "c_ban_rau")
    private String banRau;

    @Column(name = "c_ban_kem")
    private String banKem;

    @Column(name = "c_dia_chi")
    private String diaChi;

    @Column(name = "c_sdt_ch")
    private String sdtCh;

    @Column(name = "c_gs")
    private String gs;

    @Column(name = "c_sdt_gs")
    private String sdtGs;

    @Column(name = "c_cua_hang_truong")
    private String cuaHangTruong;

    @Column(name = "c_sdt_cht")
    private String sdtCht;

    @Column(name = "c_asm")
    private String asm;

    @Column(name = "c_sdt_asm")
    private String sdtAsm;

    @Column(name = "c_trang_thai")
    private String trangThai;
}
