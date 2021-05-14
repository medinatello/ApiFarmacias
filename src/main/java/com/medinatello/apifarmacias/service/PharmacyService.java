package com.medinatello.apifarmacias.service;


import com.medinatello.apifarmacias.dto.PharmacyDTO;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Farmacias Servicios
 */
@Service
public class PharmacyService {

    private Logger logger = LoggerFactory.getLogger(PharmacyService.class);

    public List<PharmacyDTO> getPharmacy(){
        List<PharmacyDTO> output = new ArrayList<>();
        PharmacyDTO pharmacyDTO = new PharmacyDTO();
        pharmacyDTO.setName("Prueba");
        pharmacyDTO.setAddress("Santiago 12 12");
        pharmacyDTO.setLatitud(1224L);
        pharmacyDTO.setLongitud(1223L);
        pharmacyDTO.setPhone("956772323");


        output.add(pharmacyDTO);
        return output;

    }



}
