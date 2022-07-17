package com.idb.webservice.JpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.idb.webservice.Entities.KhachHangLead;

@Repository
public interface KhachHangLeadRepo extends JpaRepository<KhachHangLead, String> {

    // @Query("select khl from KhachHangLead khl where khl.ten like %?1% and khl.phone like %?2% and khl.phone2 like %?3% and khl.soThe like %?4% and khl.email like %?5% and khl.diaChi like %?6% and khl.facebook like %?7% and khl.zalo like %?8% and khl.gioiTinh like %?9% and khl.thanhPho like %?10% and khl.quanHuyen like %?11% and khl.phuongXa like %?12%")
    // List<KhachHangLead> findByMyFilters(String ten, String phone, String phone2, String soThe, String email, String diaChi, String facebook, String zalo, String gioiTinh, String thanhPho, String quanHuyen, String phuongXa);

    // @Query("select khl from KhachHangLead khl where khl.ten like %?1%")
    // List<KhachHangLead> findByMyFilters(String ten);
    String query = "select khl from KhachHangLead khl where coalesce(khl.ten, '') like %?1% and coalesce(khl.phone, '') like %?2% and coalesce(khl.phone2, '') like %?3% and coalesce(khl.soThe, '') like %?4% and coalesce(khl.email, '') like %?5% and coalesce(khl.diaChi, '') like %?6% and coalesce(khl.facebook, '') like %?7% and coalesce(khl.zalo, '') like %?8% and coalesce(khl.gioiTinh, '') like %?9% and coalesce(khl.thanhPho, '') like %?10% and coalesce(khl.quanHuyen, '') like %?11% and coalesce(khl.phuongXa, '') like %?12% and (date(khl.ngaySinh) is not null and (((coalesce(date(?13), '') <> '' and coalesce(date(?14), '') <> '') and date(khl.ngaySinh) between date(?13) and date(?14)) or ((coalesce(date(?13), '') <> '' and coalesce(date(?14), '') = '') and date(khl.ngaySinh) >= date(?13)) or ((coalesce(date(?13), '') = '' and coalesce(date(?14), '') <> '') or date(khl.ngaySinh) <= date(?14)) or (coalesce(date(?13), '') = '' and coalesce(date(?14), '') = '')))";
    @Query(query)
    List<KhachHangLead> findByMyFilters(String ten, String phone, String phone2, String soThe, String email, String diaChi, String facebook, String zalo, String gioiTinh, String thanhPho, String quanHuyen, String phuongXa, String birthdayFrom, String birthdayTo);

}


// and (khl.facebook like %?7% or (khl.facebook is null and ?7 = '')) and (khl.zalo like %?8% or (khl.zalo is null and ?8 = ''))