package com.guitardojo.guitardojodata.models;

import org.springframework.data.annotation.Id;

public class Email {

    @Id
    private String id;
    private String to;
    private String from;
    private String subject;
    private String text;
    private String phone;
    private String firstName;
    private String lastName;
    private String email;
    private String message;

    public Email(){}


    // public Email(String id, String to, String from, String subject, String text, String phone, String firstName, String lastName, String email, String message) {
    //     this.id = id;
    //     this.to = to;
    //     this.from = from;
    //     this.subject = subject;
    //     this.text = text;
    //     this.phone = phone;
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.email = email;
    //     this.message = message;
    // }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}