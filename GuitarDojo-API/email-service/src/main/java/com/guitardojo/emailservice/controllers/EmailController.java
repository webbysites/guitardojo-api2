package com.guitardojo.emailservice.controllers;

import com.guitardojo.emailservice.services.EmailService;
import com.guitardojo.guitardojodata.models.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmailController {

    @Autowired
    public EmailService emailservice;

    @PostMapping("/sendEmail")
    @ResponseBody
    private String sendMail(@RequestBody Email email) {
        try {
            emailservice.SendEmailToGuitarDojo(email);
            return "Email sent!";
        } catch(Exception ex) {
            return "Error in sending email: " + ex;
        }
    
    }
}
