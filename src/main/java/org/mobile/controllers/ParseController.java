package org.mobile.controllers;

import org.mobile.models.ContactInfo;
import org.mobile.services.BusinessCardParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParseController {

    @Autowired
    private BusinessCardParserService service;


    @PostMapping("/parse")
    public ContactInfo parseText(@RequestBody String text) {
        System.out.println(text);
        return service.parseContactInfo(text);
    }
}
