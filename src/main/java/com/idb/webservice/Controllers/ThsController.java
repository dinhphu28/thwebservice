package com.idb.webservice.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idb.webservice.Entities.Ths;
import com.idb.webservice.Models.ReturnModel;
import com.idb.webservice.Models.ThsCreateModel;
import com.idb.webservice.Services.ThsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/thss")
public class ThsController {
    @Autowired
    private ThsService thsService;

    @Value("${idb.external.apikey}")
    private String localApiKey;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> retrieveAll(@RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            List<Ths> thss = thsService.retrieveAll();

            entity = new ResponseEntity<>(thss, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createOne(@RequestBody ThsCreateModel thsModel, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            Ths ths = new Ths(null, thsModel.getTpTinh(), thsModel.getQuan(), thsModel.getBanRau(), thsModel.getBanKem(), thsModel.getDiaChi(), thsModel.getSdtCh(), thsModel.getGs(), thsModel.getSdtGs(), thsModel.getCuaHangTruong(), thsModel.getSdtCht(), thsModel.getAsm(), thsModel.getSdtAsm(), thsModel.getTrangThai());

            Ths tmpSaved = thsService.createOne(ths);

            if(tmpSaved != null) {
                entity = new ResponseEntity<>(tmpSaved, HttpStatus.CREATED);
            } else {
                entity = new ResponseEntity<>(new ReturnModel("400", "Bad request!"), HttpStatus.BAD_REQUEST);
            }
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }
}
