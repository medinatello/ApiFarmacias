package com.medinatello.apifarmacias.controller;

import com.medinatello.apifarmacias.dto.PharmacyDTO;
import com.medinatello.apifarmacias.service.PharmacyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    private Logger logger = LoggerFactory.getLogger(PharmacyController.class);


    @GetMapping("/ping")
    public ResponseEntity<String> ping() {

        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @GetMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PharmacyDTO>> getAll() {
        logger.info("Services getAll");

        HttpStatus code = HttpStatus.OK;
        List<PharmacyDTO> output = new ArrayList<>();
        try{
            output = pharmacyService.getPharmacies();
            if(output == null){
                code = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            if(output.stream().count() == 0){
                code = HttpStatus.NOT_FOUND;
            }


        }catch (Exception e){
            logger.error("Error en controlador", e);
            code = HttpStatus.INTERNAL_SERVER_ERROR;

        }
        return new ResponseEntity<>(output, code);
    }

}
