package com.newmansoft.util;




import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Created by andyn on 6/5/2015.
 */
public class EmailLogger {

    public static void log( String name, Object value, String toEmail) {
        final String username = "mailer@mattandjenn2015.ca";
        final String password = "webFiles1";
        final String host = "mattandjenn2015.ca";
        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.mattandjenn2015.ca");
        props.put("mail.smtp.starttls.enable", "false");

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug","true");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mailer@mattandjenn2015.ca"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            message.setSubject(name);
            message.setText(value.toString());

            Transport.send(message);


        } catch (MessagingException e) {
         //DO NOTHING! Don't break on logging errors.
        }

    }

    public static void logGmail( String name, Object value) throws MessagingException, UnsupportedEncodingException {
        final String username = "andyn.emailer@gmail.com";
        final String password = "webFiles1";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug","true");



        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        // construct the message
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, username, "utf-8"));
        if (username!= null) {
            InternetAddress[] replyToAddresses = new InternetAddress[1];
            replyToAddresses[0] = new InternetAddress(username);
            msg.setReplyTo(replyToAddresses);
        }
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("andyandem2016+server@gmail.com", false));
        msg.setSubject("testgmail", "UTF-8");


        msg.setHeader("X-Mailer", "msgsend");
        msg.setSentDate(new Date());

        // send the thing off
            Transport.send(msg);
    }
}
