package com.medinatello.apifarmacias.service;


import com.medinatello.apifarmacias.dao.rest.PharmacyRestDAO;
import com.medinatello.apifarmacias.domain.entity.Pharmacy;
import com.medinatello.apifarmacias.dto.PharmacyDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PharmacyRestDAO pharmacyRestDAO;

    public List<PharmacyDTO> getPharmacies(){

        List<PharmacyDTO> output = new ArrayList<>();

        var pharmacies = pharmacyRestDAO.getPharmacy();
        if(pharmacies == null || pharmacies.stream().count() == 0){
            return output;
        }

        pharmacies.stream().forEach( f -> {
            output.add(toPharmacyDTO(f));
        });

        return output;

    }


    public List<PharmacyDTO> getPharmacyMock(){
        List<PharmacyDTO> output = new ArrayList<>();
        PharmacyDTO pharmacyDTO = new PharmacyDTO();
        pharmacyDTO.setName("Prueba");
        pharmacyDTO.setAddress("Santiago 12 12");
        pharmacyDTO.setPhone("956772323");


        output.add(pharmacyDTO);
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
