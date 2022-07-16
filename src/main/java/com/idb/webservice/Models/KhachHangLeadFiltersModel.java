package com.idb.webservice.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangLeadFiltersModel {

    private String ten;

    private String phone;

    private String phone2;

    private String soThe;

    private String email;

    private String diaChi;

    private String facebook;

    private String zalo;

    private String gioiTinh;

    private String fkCD;

    private String thanhPho;

    private String quanHuyen;
    
    private String phuongXa;

    private String birthdayFrom;
    
    private  String birthdayTo;
}
