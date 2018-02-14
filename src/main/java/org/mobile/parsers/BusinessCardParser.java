package org.mobile.parsers;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.mobile.models.ContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BusinessCardParser {

    @Autowired
    private EmailAddressParser emailAddressParser;
    @Autowired
    private NameParser nameParser;
    @Autowired
    private PhoneNumberParser phoneNumberParser;

    /**
     * Parse through a newline separated document in an attempt to create a ContactInfo object.
     * This will run through the document line by line, trying to match on an email address first,
     * and if there is no match, find a phone number next. Finally, if no match with those, it will
     * attempt the human name recognition.
     *
     * @param document
     * @return
     */
    public ContactInfo getContactInfo(String document) {
        ContactInfo info = null;

        if (StringUtils.trimToNull(document) != null) {
            info = new ContactInfo();
            String[] lines = document.split("\\r?\\n");

            for (String line : lines) {
                String email = emailAddressParser.findEmailAddress(line);
                if(email != null) {
                    info.setEmailAddress(email);
                } else {
                    String phone = phoneNumberParser.findPhoneNumber(line);
                    if(phone != null) {
                        info.setPhoneNumber(phone);
                    } else {
                        String name = nameParser.findName(line);
                        if (name != null) {
                            info.setName(name);
                        }
                    }
                }
            }
        }
        return info;
    }

}
