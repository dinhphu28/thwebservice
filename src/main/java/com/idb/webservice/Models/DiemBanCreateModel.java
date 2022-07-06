package com.idb.webservice.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiemBanCreateModel {
    private String maCuaHang;

    private String tenCuaHang;

    private String diaChi;

    private String sdtDangKy;

    private String tenNpp;

    private String tenGsbh;

    private String emailGsbh;

    private String sdtGsbh;

    private String asm;

    private String emailAsm;

    private String sdtAsm;
}
