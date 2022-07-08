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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idb.webservice.Entities.ProductOrdered;
import com.idb.webservice.Entities.SanPham;
import com.idb.webservice.Entities.SpTicket;
import com.idb.webservice.Models.ProductOrderMailTemplateModel;
import com.idb.webservice.Models.ReturnModel;
import com.idb.webservice.Models.SpTicketUpdateModel;
import com.idb.webservice.Services.ProductOrderedService;
import com.idb.webservice.Services.SanPhamService;
import com.idb.webservice.Services.SpTicketService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/sptickets")
public class SpTicketController {
    @Autowired
    private SpTicketService service;

    @Autowired
    private ProductOrderedService productOrderedService;

    @Autowired
    private SanPhamService sanPhamService;

    @Value("${idb.internal.apikey}")
    private String localApiKey;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> getSpTickets(@RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            List<SpTicket> spTickets = service.retrieveAll();

            entity = new ResponseEntity<>(spTickets, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }

    @GetMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> retrieveSpTicketById(@PathVariable("id") String id, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            SpTicket ret = service.retrieveById(id);

            if(ret != null) {
                entity = new ResponseEntity<>(ret, HttpStatus.OK);
            } else {
                entity = new ResponseEntity<>("{ \"Notice\": \"Invalid Input\" }", HttpStatus.NOT_FOUND);
            }
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> updateSpTicket(@RequestBody SpTicket spTicket, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            SpTicket tmp = service.updateOne(spTicket);

            entity = new ResponseEntity<>(tmp, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }

    @PutMapping(
        value = "/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> updateSpTicketById(@PathVariable("id") String id, @RequestBody SpTicketUpdateModel spTicket, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            SpTicket tmpToSave = service.retrieveById(id);

            tmpToSave.setNgayHenGap(spTicket.getNgayHenGap());
            tmpToSave.setNgayGoiLaiKhieuNai(spTicket.getNgayGoiLaiKhieuNai());
            tmpToSave.setNgayHenGoiLai(spTicket.getNgayHenGoiLai());
            tmpToSave.setNgayGiaohang(spTicket.getNgayGiaohang());

            SpTicket tmpSaved = service.updateOne(tmpToSave);

            if(tmpSaved != null) {
                entity = new ResponseEntity<>(tmpSaved, HttpStatus.OK);
            } else {
                entity = new ResponseEntity<>("{ \"Notice\": \"Invalid Input\" }", HttpStatus.BAD_REQUEST);
            }
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }

    // Ticket product ordered
    @GetMapping(
        value = "/{ticketId}/orderedproducts"
    )
    public ResponseEntity<Object> retrieveProductOrderByTicketId(@PathVariable("ticketId") String ticketId, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            List<ProductOrderMailTemplateModel> orderedProducts = new ArrayList<ProductOrderMailTemplateModel>();

            List<ProductOrdered> productOrdereds = productOrderedService.retrieveByTicketId(ticketId);
            for (ProductOrdered productOrdered : productOrdereds) {
                SanPham sanPhamTmp = sanPhamService.retrieveOneById(productOrdered.getSanPham());

                // ProductOrderMailTemplateModel tmpOP = new ProductOrderMailTemplateModel(sanPhamTmp.getTenSp(), productOrdered.getSoLuong(), productOrdered.getGhiChu());

                // orderedProducts.add(tmpOP);

                if(sanPhamTmp != null) {
                    ProductOrderMailTemplateModel tmpOP = new ProductOrderMailTemplateModel(sanPhamTmp.getTenSp(), productOrdered.getSoLuong(), productOrdered.getGhiChu());

                    orderedProducts.add(tmpOP);
                }
            }

            entity = new ResponseEntity<>(orderedProducts, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }
}
