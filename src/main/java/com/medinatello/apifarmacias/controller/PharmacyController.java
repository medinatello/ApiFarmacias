package com.medinatello.apifarmacias.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Farmacia Rest Controller
 */
@RestController
@RequestMapping("/api/pharmacy")
@CrossOrigin(origins = "*")
public class PharmacyController {

    @GetMapping("/ping")
    public ResponseEntity<String> index() {

        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

}
