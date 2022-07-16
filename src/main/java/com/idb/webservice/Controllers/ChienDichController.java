package com.idb.webservice.Controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idb.webservice.Entities.AppEnvVariable;
import com.idb.webservice.Entities.KhachHangLead;
import com.idb.webservice.Entities.KhachHangLeadChienDichDataTls;
import com.idb.webservice.Entities.IdClasses.AppEnvVariableId;
import com.idb.webservice.Models.KhachHangFiltersRequestModel;
import com.idb.webservice.Models.KhachHangLeadFiltersModel;
import com.idb.webservice.Models.ReturnModel;
import com.idb.webservice.Services.AppEnvVariableService;
import com.idb.webservice.Services.KhachHangLeadChienDichDataTlsService;
import com.idb.webservice.Services.KhachHangLeadService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/chiendichs")
public class ChienDichController {
    @Autowired
    private KhachHangLeadService khachHangLeadService;

    @Autowired
    private KhachHangLeadChienDichDataTlsService khachHangLeadChienDichDataTlsService;

    @Autowired
    private AppEnvVariableService appEnvVariableService;

    @Value("${idb.internal.apikey}")
    private String localApiKey;

    @PostMapping(
        value = "/{cdid}/chiendichdata",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE 
    )
    public ResponseEntity<Object> retrieveByMyFiltersAndAddToCDDT(@RequestBody KhachHangFiltersRequestModel requestModel, @PathVariable("cdid") String cdid, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            KhachHangLeadFiltersModel filtersModel = requestModel.getFilters();

            List<KhachHangLeadChienDichDataTls> tmpToSaves = new ArrayList<KhachHangLeadChienDichDataTls>();

            List<KhachHangLeadChienDichDataTls> existedInCD = khachHangLeadChienDichDataTlsService.retrieveByFkCD(cdid);

            AppEnvVariableId appEnvVariableId = new AppEnvVariableId("chiendich_count_data", "sp2", 1);

            List<KhachHangLead> khachHangLeads = khachHangLeadService.retrieveByMyFilters(filtersModel.getTen(), filtersModel.getPhone(), filtersModel.getPhone2(), filtersModel.getSoThe(), filtersModel.getEmail(), filtersModel.getDiaChi(), filtersModel.getFacebook(), filtersModel.getZalo(), filtersModel.getGioiTinh(), filtersModel.getThanhPho(), filtersModel.getQuanHuyen(), filtersModel.getPhuongXa(), filtersModel.getBirthdayFrom(), filtersModel.getBirthdayTo());

            for (KhachHangLead item : khachHangLeads) {
                Boolean isExisted = false;
                for (KhachHangLeadChienDichDataTls exItem : existedInCD) {
                    if(exItem.getFkKH().equals(item.getId())) {
                        isExisted = true;
                    }
                }

                if(!isExisted) {
                    LocalDateTime today = LocalDateTime.now();

                    KhachHangLeadChienDichDataTls tmp = new KhachHangLeadChienDichDataTls(null, item.getTen(), item.getPhone(), item.getPhone2(), item.getSoThe(), item.getEmail(), item.getDiaChi(), item.getFacebook(), item.getZalo(), item.getGioiTinh(), cdid, item.getNgaySinh(), item.getThanhPho(), item.getQuanHuyen(), item.getPhuongXa(), item.getGhiChu(), item.getId(), "999", today, today, requestModel.getUsername(), requestModel.getFullname(), requestModel.getUsername(), requestModel.getFullname());

                    tmpToSaves.add(tmp);
                }
            }

            AppEnvVariable appEnvVariable = appEnvVariableService.retrieveById(appEnvVariableId);
            Integer stt = Integer.parseInt(appEnvVariable.getValue());
            Integer newStt = stt + tmpToSaves.size();

            List<KhachHangLeadChienDichDataTls> tmpToSaves2 = new ArrayList<KhachHangLeadChienDichDataTls>();

            for(int i = stt + 1; i <= newStt; i++) {
                KhachHangLeadChienDichDataTls tmpz = tmpToSaves.get(i - stt - 1);

                tmpz.setStt("" + i);

                tmpToSaves2.add(tmpz);
            }

            List<KhachHangLeadChienDichDataTls> tmpSaved = khachHangLeadChienDichDataTlsService.createMulti(tmpToSaves2);

            entity = new ResponseEntity<>(tmpSaved, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }
}
