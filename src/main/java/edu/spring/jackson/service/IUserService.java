package edu.spring.jackson.service;

import edu.spring.jackson.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.io.IOException;

//@Repository
public interface IUserService {

    User printDataByEmail(String email);

    HttpStatus addUser(String name, String surName, String email) throws IOException;
}


