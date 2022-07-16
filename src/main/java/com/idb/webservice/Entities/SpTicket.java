package com.idb.webservice.Entities;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "app_fd_sp_tickets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpTicket {
    
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "c_tieude")
    private String tieuDe;

    @Column(name = "c_ngay_hen_gap")
    private LocalDateTime ngayHenGap;

    @Column(name = "c_goi_lai_khieu_nai")
    private LocalDateTime ngayGoiLaiKhieuNai;

    @Column(name = "c_hen_goi_lai")
    private LocalDateTime ngayHenGoiLai;

    @Column(name = "c_thoi_gian_giao_hang")
    private LocalDateTime ngayGiaohang;

    @Column(name = "c_fknguoixuly")
    private String agentXuLy;
}
