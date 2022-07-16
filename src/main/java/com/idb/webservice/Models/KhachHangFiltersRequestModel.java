package com.idb.webservice.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangFiltersRequestModel {
    private KhachHangLeadFiltersModel filters;

    private String username;

    private String fullname;
}
