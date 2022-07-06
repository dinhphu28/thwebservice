package com.idb.webservice.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idb.webservice.Models.DiemBanBatchCreateModel;
import com.idb.webservice.Models.ReturnModel;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/diembans")
public class DiemBanController {


    @Value("${idb.external.apikey}")
    private String localApiKey;
    
    @PostMapping(
        value = "/create-many.json",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createBatch(@RequestBody DiemBanBatchCreateModel diemBanBatch, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            entity = new ResponseEntity<>(diemBanBatch.getDiemBans(), HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }
}
