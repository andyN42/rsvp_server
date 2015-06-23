package com.newmansoft.util;

import com.newmansoft.controller.EmailController;
import com.newmansoft.model.GuestDto;
import junit.framework.TestCase;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * Created by andyn on 6/5/2015.
 */
public class EmailLoggerTest extends TestCase {


    public void testMe() {

        EmailLogger logger = new EmailLogger();

        GuestDto guest = new GuestDto();
        guest.setId(1L);
        guest.setFirstName("testFN");
        guest.setFirstName("testLN");
        guest.setEmail("testEMail");

        logger.log("test",guest, "andyandem2016+server@gmail.com");
    }

    public void testMeGmail() {

        EmailController controller = new EmailController();

        EmailLogger logger = new EmailLogger();

        GuestDto guest = new GuestDto();
        guest.setId(1L);
        guest.setFirstName("testFN");
        guest.setFirstName("testLN");
        guest.setEmail("testEMail");

        try {
            logger.logGmail("test", guest);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}