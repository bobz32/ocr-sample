package org.mobile.parsers;

import org.junit.Assert;
import org.junit.Test;

public class ParserTests {

    @Test
    public void testPhoneParser() {
        PhoneNumberParser parser = new PhoneNumberParser();

        String number = parser.findPhoneNumber("+1 (555) 555-5555");
        Assert.assertEquals("15555555555", number);

        number = parser.findPhoneNumber("(555)555-5555");
        Assert.assertEquals("5555555555", number);

        number = parser.findPhoneNumber("555-555-5555");
        Assert.assertEquals("5555555555", number);

        number = parser.findPhoneNumber("Baltimore, MD 21231");
        Assert.assertNull(number);
    }

    @Test
    public void testEmailAddressParser() {
        EmailAddressParser parser = new EmailAddressParser();

        String email = parser.findEmailAddress("Email: test@test.com");
        Assert.assertEquals("test@test.com", email);

        email = parser.findEmailAddress("test@test.com");
        Assert.assertEquals("test@test.com", email);

        email = parser.findEmailAddress("Hello Sir");
        Assert.assertNull(email);
    }

    @Test
    public void testNameParser() {
        NameParser parser = new NameParser();

        String name = parser.findName("Ron Swanson");
        Assert.assertEquals("Ron Swanson", name);

        name = parser.findName("Mr. Ron Swanson");
        Assert.assertEquals("Ron Swanson", name);

        name = parser.findName("Department of Parks and Recreation");
        Assert.assertNull(name);
    }
}
