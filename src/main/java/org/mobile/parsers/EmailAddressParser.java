package org.mobile.parsers;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
public class EmailAddressParser {

    //get the email validator, and do not allow local addresses
    private EmailValidator emailValidator = EmailValidator.getInstance(false);

    /**
     * Splits line on whitespace, and attempts to parse an email address from each token. The last email address
     * is return if multiple, or null if no matches.
     * @param line
     * @return
     */
    public String findEmailAddress(String line) {
        String email = null;
        //split on whitespace and process each token, take the last address if there are multiple
        for (String token : line.split("\\s")) {
            if(emailValidator.isValid(token)) {
                email = token;
            }
        }

        return email;
    }
}
