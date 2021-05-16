package com.medinatello.apifarmacias.service;


import com.medinatello.apifarmacias.dao.PharmacyRepo;
import com.medinatello.apifarmacias.dao.rest.PharmacyRestDAO;
import com.medinatello.apifarmacias.domain.entity.Pharmacy;
import com.medinatello.apifarmacias.dto.PharmacyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Farmacias Servicios
 */
@Service
public class PharmacyService {

    private Logger logger = LoggerFactory.getLogger(PharmacyService.class);

    @Autowired
    private PharmacyRepo pharmacyRepo;

    public List<PharmacyDTO> getPharmacies(String comuna){

        List<PharmacyDTO> output = new ArrayList<>();
        List<Pharmacy> pharmacies = null;
        if(comuna.length() == 0){
            pharmacies = pharmacyRepo.getAll();
        }else {
            pharmacies = pharmacyRepo.getAllByComunas(comuna.toUpperCase());
        }


        if(pharmacies == null || pharmacies.stream().count() == 0){
            return null;
        }
        if(comuna.length()>0){
            pharmacies = pharmacies.stream().filter(f -> f.getComuna_nombre().toUpperCase().equals(comuna)).collect(Collectors.toList());
        }

        pharmacies.stream().forEach( f -> {
            output.add(toPharmacyDTO(f));
        });

        return output;

    }


    private PharmacyDTO toPharmacyDTO(Pharmacy pharmacy){

        PharmacyDTO output = new PharmacyDTO();

        output.setName(pharmacy.getLocal_nombre());
        output.setAddress(pharmacy.getLocal_direccion());
        output.setLatitud(pharmacy.getLocal_lat());
        output.setLongitud(pharmacy.getLocal_lng());
        output.setPhone(pharmacy.getLocal_telefono());

        return output;
    }


}
