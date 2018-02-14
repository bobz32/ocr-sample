package org.mobile.controllers;

import org.mobile.models.ContactInfo;
import org.mobile.services.BusinessCardParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles a quick post of a string representation of OCR'ed data for parsing
 */
@RestController
public class ParseController {

    @Autowired
    private BusinessCardParserService service;


    /**
     * Takes in OCR'ed business card data, and returns a ContactInfo object with parsed values
     * @param text OCR'ed text to be parsed
     * @return populated ContactInfo or null if text is null
     */
    @PostMapping("/parse")
    public ContactInfo parseText(@RequestBody String text) {
        return service.parseContactInfo(text);
    }
}
