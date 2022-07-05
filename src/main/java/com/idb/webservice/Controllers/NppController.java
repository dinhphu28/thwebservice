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

import com.idb.webservice.Entities.Npp;
import com.idb.webservice.Models.NppCreateModel;
import com.idb.webservice.Models.ReturnModel;
import com.idb.webservice.Services.NppService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/npps")
public class NppController {
    @Autowired
    private NppService nppService;

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
            List<Npp> npps = nppService.retrieveAll();

            entity = new ResponseEntity<>(npps, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createOne(@RequestBody NppCreateModel nppModel, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            Npp npp = new Npp(null, nppModel.getKenh(), nppModel.getMien(), nppModel.getTinhThanh(), nppModel.getQuanHuyen(), nppModel.getQuanHuyen(), nppModel.getGiamSat01Ten(), nppModel.getGiamSat02Sdt(), nppModel.getTenAsm(), nppModel.getDtAsm(), nppModel.getTenSm(), nppModel.getDtSm(), nppModel.getTrangThai());

            Npp tmpSaved = nppService.createOne(npp);

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
