package org.mobile.services;

import org.mobile.models.ContactInfo;
import org.mobile.parsers.BusinessCardParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCardParserService {

    @Autowired
    private BusinessCardParser businessCardParser;

    /**
     * Takes a string of business card data and attempts to return properly parsed contact information
     * @param document
     * @return
     */
    public ContactInfo parseContactInfo(String document) {
        return businessCardParser.getContactInfo(document);
    }
}
