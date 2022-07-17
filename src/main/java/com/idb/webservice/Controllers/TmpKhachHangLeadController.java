// package com.idb.webservice.Controllers;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.idb.webservice.Entities.AppEnvVariable;
// import com.idb.webservice.Entities.KhachHangLead;
// import com.idb.webservice.Entities.KhachHangLeadChienDichDataTls;
// import com.idb.webservice.Entities.IdClasses.AppEnvVariableId;
// import com.idb.webservice.Models.KhachHangFiltersRequestModel;
// import com.idb.webservice.Models.KhachHangLeadFiltersModel;
// import com.idb.webservice.Services.AppEnvVariableService;
// import com.idb.webservice.Services.KhachHangLeadChienDichDataTlsService;
// import com.idb.webservice.Services.KhachHangLeadService;

// @RestController
// @CrossOrigin("*")
// @RequestMapping("/api/v1/khachhangleads")
// public class TmpKhachHangLeadController {
//     @Autowired
//     private KhachHangLeadService khachHangLeadService;

//     @Autowired
//     private KhachHangLeadChienDichDataTlsService khachHangLeadChienDichDataTlsService;

//     @Autowired
//     private AppEnvVariableService appEnvVariableService;

//     @PostMapping(
//         produces = MediaType.APPLICATION_JSON_VALUE,
//         consumes = MediaType.APPLICATION_JSON_VALUE
//     )
//     public ResponseEntity<Object> retrieveByMyFilters(@RequestBody KhachHangLeadFiltersModel filtersModel) {
//         ResponseEntity<Object> entity;

//         List<KhachHangLead> khachHangLeads = khachHangLeadService.retrieveByMyFilters(filtersModel.getTen(), filtersModel.getPhone(), filtersModel.getPhone2(), filtersModel.getSoThe(), filtersModel.getEmail(), filtersModel.getDiaChi(), filtersModel.getFacebook(), filtersModel.getZalo(), filtersModel.getGioiTinh(), filtersModel.getThanhPho(), filtersModel.getQuanHuyen(), filtersModel.getPhuongXa(), filtersModel.getBirthdayFrom(), filtersModel.getBirthdayTo());

//         entity = new ResponseEntity<>(khachHangLeads, HttpStatus.OK);

//         return entity;
//     }

//     // public ResponseEntity<Object> retrieveByMyFilters(@RequestBody KhachHangLeadFiltersModel filtersModel) {
//     //     ResponseEntity<Object> entity;

//     //     List<KhachHangLead> khachHangLeads = khachHangLeadService.retrieveByMyFilters(filtersModel.getTen());

//     //     entity = new ResponseEntity<>(khachHangLeads, HttpStatus.OK);

//     //     return entity;
//     // }
//     @PostMapping(
//         value = "/addtocddt/{cdid}",
//         produces = MediaType.APPLICATION_JSON_VALUE,
//         consumes = MediaType.APPLICATION_JSON_VALUE
//     )
//     public ResponseEntity<Object> retrieveByMyFiltersAndAddToCDDT(@RequestBody KhachHangFiltersRequestModel requestModel, @PathVariable("cdid") String cdid) {
//         ResponseEntity<Object> entity;

//         KhachHangLeadFiltersModel filtersModel = requestModel.getFilters();

//         List<KhachHangLeadChienDichDataTls> tmpToSaves = new ArrayList<KhachHangLeadChienDichDataTls>();

//         List<KhachHangLeadChienDichDataTls> existedInCD = khachHangLeadChienDichDataTlsService.retrieveByFkCD(cdid);

//         AppEnvVariableId appEnvVariableId = new AppEnvVariableId("chiendich_count_data", "sp2", 1);

//         List<KhachHangLead> khachHangLeads = khachHangLeadService.retrieveByMyFilters(filtersModel.getTen(), filtersModel.getPhone(), filtersModel.getPhone2(), filtersModel.getSoThe(), filtersModel.getEmail(), filtersModel.getDiaChi(), filtersModel.getFacebook(), filtersModel.getZalo(), filtersModel.getGioiTinh(), filtersModel.getThanhPho(), filtersModel.getQuanHuyen(), filtersModel.getPhuongXa(), filtersModel.getBirthdayFrom(), filtersModel.getBirthdayTo());

//         for (KhachHangLead item : khachHangLeads) {
            
//             // AppEnvVariable appEnvVariable = appEnvVariableService.retrieveById(appEnvVariableId);
//             // Integer stt = Integer.parseInt(appEnvVariable.getValue()) + 1;

//             // appEnvVariable.setValue("" + (stt + 1));
//             // appEnvVariableService.updateOne(appEnvVariable);
//             Boolean isExisted = false;
//             for (KhachHangLeadChienDichDataTls exItem : existedInCD) {
//                 if(exItem.getFkKH().equals(item.getId())) {
//                     isExisted = true;
//                 }
//             }

//             if(!isExisted) {
//                 LocalDateTime today = LocalDateTime.now();

//                 KhachHangLeadChienDichDataTls tmp = new KhachHangLeadChienDichDataTls(null, item.getTen(), item.getPhone(), item.getPhone2(), item.getSoThe(), item.getEmail(), item.getDiaChi(), item.getFacebook(), item.getZalo(), item.getGioiTinh(), cdid, item.getNgaySinh(), item.getThanhPho(), item.getQuanHuyen(), item.getPhuongXa(), item.getGhiChu(), item.getId(), "999", today, today, requestModel.getUsername(), requestModel.getFullname(), requestModel.getUsername(), requestModel.getFullname());

//                 tmpToSaves.add(tmp);
//             }
//         }

//         AppEnvVariable appEnvVariable = appEnvVariableService.retrieveById(appEnvVariableId);
//         Integer stt = Integer.parseInt(appEnvVariable.getValue());
//         Integer newStt = stt + tmpToSaves.size();

//         List<KhachHangLeadChienDichDataTls> tmpToSaves2 = new ArrayList<KhachHangLeadChienDichDataTls>();

//         for(int i = stt + 1; i <= newStt; i++) {
//             KhachHangLeadChienDichDataTls tmpz = tmpToSaves.get(i - stt - 1);

//             tmpz.setStt("" + i);

//             tmpToSaves2.add(tmpz);
//         }

//         List<KhachHangLeadChienDichDataTls> tmpSaved = khachHangLeadChienDichDataTlsService.createMulti(tmpToSaves2);

//         entity = new ResponseEntity<>(tmpSaved, HttpStatus.OK);

//         return entity;
//     }
// }
