package com.guitardojo.guitardojodata.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guitardojo.guitardojodata.models.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
