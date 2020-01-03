package com.guitardojo.emailservice.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.guitardojo.guitardojodata.models.Email;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@EnableEncryptableProperties
public class EmailService {

    @Value("${spring.mail.username}")
    private String user;

    @Value("${spring.mail.password}")
    private String password;

    private final String host = "email-smtp.us-east-1.amazonaws.com";
    private Properties props = new Properties();
    protected Session session;


    // Setup
    private void setup() {

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
    }

    public void SendEmailToGuitarDojo(Email email) {
        setup();
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("donotreply@guitardojosatx.com"));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("guitardojosatx@gmail.com"));
            message.setSubject(email.getFirstName() + email.getLastName() + " has asked about more info dog!!");
            String htmlText = "<html><body>" +
                "<h3>Follow up with: " + email.getFirstName() + "</h3>" + 
                "<h4>email: " + email.getEmail() + "</h4>" +
                "<h4>phone number: " + email.getPhone() + "</h4>" +
                "<h4>Dude! they said: " + email.getMessage() + "</h4>" +
                "</body></html>";
            message.setContent(htmlText, "text/html");
            Transport.send(message);
            System.out.println("Sent successfully - ADMIN");;
         } catch (MessagingException e) {
             throw new RuntimeException(e);
         }
    }

}