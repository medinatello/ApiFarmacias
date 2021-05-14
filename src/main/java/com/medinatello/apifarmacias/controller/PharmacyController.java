package com.medinatello.apifarmacias.controller;

import com.medinatello.apifarmacias.dto.PharmacyDTO;
import com.medinatello.apifarmacias.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Farmacia Rest Controller
 */
@RestController
@RequestMapping("/api/pharmacy")
@CrossOrigin(origins = "*")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {

        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @GetMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PharmacyDTO>> getAll() {
        var output = pharmacyService.getPharmacy();

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
