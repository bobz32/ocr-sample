package org.mobile.parsers;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PhoneNumberParser {

    //match on anything following by a combo of digits, dash or parents or spaces, minimum 10 total chars
    private Pattern phoneNumberPattern = Pattern.compile(".*([0-9 ()-]{10,})");

    /**
     * Attempts to find digits in a line of text. All non-digits are returned as the number, or null if no match
     *
     * @param line
     * @return
     */
    public String findPhoneNumber(String line) {
        String phone = null;
        if (line != null) {
            //just make sure it doesn't start with FAX or some sort before we regex match it
            String upperLine = line.toUpperCase();
            //two basic cases, FAX or FACSIMILE
            if (!upperLine.startsWith("FAX") && !upperLine.startsWith("FAC")) {
                Matcher phoneMatcher = phoneNumberPattern.matcher(line);
                if (phoneMatcher.matches()) {
                    //strip out all non-digits
                    phone = phoneMatcher.group(0).replaceAll("[^\\d]", "");
                }
            }
        }

        return phone;
    }
}
