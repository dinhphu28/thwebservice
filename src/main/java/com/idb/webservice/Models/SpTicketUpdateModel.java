package com.idb.webservice.Models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpTicketUpdateModel {

    private LocalDateTime ngayHenGap;

    private LocalDateTime ngayGoiLaiKhieuNai;

    private LocalDateTime ngayHenGoiLai;

    private LocalDateTime ngayGiaohang;
}
