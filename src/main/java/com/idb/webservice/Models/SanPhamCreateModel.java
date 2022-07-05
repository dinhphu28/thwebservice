package com.idb.webservice.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamCreateModel {
    private String dongSp;

    private String theTich;

    private String tenSp;

    private String soHop;

    private String baoGia;

    private String hsd;

    private String baoQuan;

    private String trangThai;
}
