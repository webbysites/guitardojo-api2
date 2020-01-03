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

    private final String host = "email-smtp.us-east-1.amazon.com";
    private Properties props = new Properties();
    private Session session;

    // Setup
    private void setup() {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

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
            message.setSubject(email.getFirstName() + email.getLastName() + "has asked about more info dog!!");
            String htmlText = "<html><body>" +
                "<h2>Follow up with: " + email.getFirstName() + "</h2>" + 
                "<br>" +
                "<h4>At: " + email.getTo() + "</h4>" +
                "<br> <br>" +
                "<h4>Phone number: " + email.getPhone() + "</h4>" +
                "<br>" +
                "</body></html>";
            message.setContent(htmlText, "text/html");
            Transport.send(message);
            System.out.println("Sent successfully - ADMIN");;
         } catch (MessagingException e) {
             throw new RuntimeException(e);
         }
    }

}