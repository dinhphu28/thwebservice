package com.idb.webservice.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idb.webservice.Entities.SpTicket;
import com.idb.webservice.Models.SpTicketUpdateModel;
import com.idb.webservice.Services.SpTicketService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/sptickets")
public class SpTicketController {
    @Autowired
    private SpTicketService service;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> getSpTickets() {
        ResponseEntity<Object> entity;

        List<SpTicket> spTickets = service.retrieveAll();

        entity = new ResponseEntity<>(spTickets, HttpStatus.OK);

        return entity;
    }

    @GetMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> retrieveSpTicketById(@PathVariable("id") String id) {
        ResponseEntity<Object> entity;

        SpTicket ret = service.retrieveById(id);

        if(ret != null) {
            entity = new ResponseEntity<>(ret, HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>("{ \"Notice\": \"Invalid Input\" }", HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> updateSpTicket(@RequestBody SpTicket spTicket) {
        ResponseEntity<Object> entity;

        SpTicket tmp = service.updateOne(spTicket);

        entity = new ResponseEntity<>(tmp, HttpStatus.OK);

        return entity;
    }

    @PutMapping(
        value = "/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> updateSpTicketById(@PathVariable("id") String id, @RequestBody SpTicketUpdateModel spTicket) {
        ResponseEntity<Object> entity;

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

        return entity;
    }
}
