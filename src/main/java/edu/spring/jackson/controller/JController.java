package edu.spring.jackson.controller;

import edu.spring.jackson.exception.SpringMockMvcException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.jackson.dto.User;
import edu.spring.jackson.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class JController {
    private IUserService iUserService;

    @ResponseBody
    @GetMapping(value = "/{email}")
    public User printDataByEmail(@PathVariable("email")
                                         String email) {
        return iUserService.printDataByEmail(email);
    }

    @ResponseBody
    @PostMapping(value = "/add")
    public HttpStatus addUser(
            @RequestParam(value = "userName") String name,
            @RequestParam(value = "userSurName") String surName,
            @RequestParam(value = "userEmail") String email

    ) throws IOException {
        return iUserService.addUser(name, surName, email);
    }
   // @ExceptionHandler(SpringMockMvcException.class)
    //public Re
}


