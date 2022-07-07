package com.idb.webservice.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idb.webservice.Entities.MailGroupContent;
import com.idb.webservice.Models.ReturnModel;
import com.idb.webservice.Services.MailGroupContentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/mailgroupcontents")
public class MailGroupContentController {
    @Autowired
    private MailGroupContentService mailGroupContentService;

    @Value("${idb.external.apikey}")
    private String localApiKey;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> retrieveAll(@RequestParam(value = "groupId", required = false) String groupId, @RequestHeader(value = "X-API-KEY", required = false) String apiKey) {
        ResponseEntity<Object> entity;

        if(apiKey == null) {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        } else if(apiKey.equals(localApiKey)) {
            if(groupId != null) {
                List<MailGroupContent> mailGroupContents = mailGroupContentService.retrieveByGroupId(groupId);
    
                entity = new ResponseEntity<>(mailGroupContents, HttpStatus.OK);
            } else {
                List<MailGroupContent> mailGroupContents = mailGroupContentService.retriveAll();
    
                entity = new ResponseEntity<>(mailGroupContents, HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            entity = new ResponseEntity<>(new ReturnModel("401", "Unauthorized"), HttpStatus.UNAUTHORIZED);
        }

        return entity;
    }
}
