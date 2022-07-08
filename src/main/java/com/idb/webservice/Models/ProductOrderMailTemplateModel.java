package com.idb.webservice.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderMailTemplateModel {
    
    private String sanPham;

    private String soLuong;

    private String ghiChu;
}
