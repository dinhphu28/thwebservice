package com.idb.webservice.Controllers;

import java.util.ArrayList;
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

import com.idb.webservice.Entities.SanPham;
import com.idb.webservice.Models.ReturnModel;
import com.idb.webservice.Models.SanPhamBatchCreateModel;
import com.idb.webservice.Models.SanPhamCreateModel;
import com.idb.webservice.Services.SanPhamService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/sanphams")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

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
            List<SanPham> sanPhams = sanPhamService.retrieveAll();

            entity = new ResponseEntity<>(sanPhams, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createOne(@RequestBody SanPhamCreateModel sanPhamModel, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            SanPham sanPham = new SanPham(null, sanPhamModel.getDongSp(), sanPhamModel.getTheTich(), sanPhamModel.getTheTich(), sanPhamModel.getSoHop(), sanPhamModel.getBaoGia(), sanPhamModel.getHsd(), sanPhamModel.getBaoQuan(), sanPhamModel.getTrangThai());

            SanPham tmpSaved = sanPhamService.createOne(sanPham);

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

    @PostMapping(
        value = "/create-many.json",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createBatch(@RequestBody SanPhamBatchCreateModel sanPhamBatch) {
        ResponseEntity<Object> entity;

        List<SanPham> sanPhams = new ArrayList<SanPham>();
        List<SanPhamCreateModel> sanPhamModels = sanPhamBatch.getSanPhams();

        for (SanPhamCreateModel sanPhamCreateModel : sanPhamModels) {
            SanPham sanPham = new SanPham(null, sanPhamCreateModel.getDongSp(), sanPhamCreateModel.getTheTich(), sanPhamCreateModel.getTenSp(), sanPhamCreateModel.getSoHop(), sanPhamCreateModel.getBaoGia(), sanPhamCreateModel.getHsd(), sanPhamCreateModel.getBaoQuan(), sanPhamCreateModel.getTrangThai());

            sanPhams.add(sanPham);
        }

        List<SanPham> tmpSaved = sanPhamService.createMulti(sanPhams);

        entity = new ResponseEntity<>(tmpSaved, HttpStatus.OK);

        return entity;
    }
}
