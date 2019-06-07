package com.lambdaschool.gdp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dogs")
public class test
{
    @GetMapping(value = "/dogs")
    public ResponseEntity<?> getAllDogs()
    {


        return new ResponseEntity<String>("heelo", HttpStatus.OK);
    }
}
