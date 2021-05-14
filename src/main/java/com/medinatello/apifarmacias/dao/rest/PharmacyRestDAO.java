package com.medinatello.apifarmacias.dao.rest;

import com.medinatello.apifarmacias.domain.entity.Pharmacy;
import com.medinatello.apifarmacias.service.PharmacyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyRestDAO {

    private static final String URL_PHARMACY  = "https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion?id_region=7";
    private Logger logger = LoggerFactory.getLogger(PharmacyService.class);


    public List<Pharmacy> getPharmacy(){
        List<Pharmacy> output = new ArrayList<>();

        try{

            RestTemplate pharmacyRest = new RestTemplate();
            var response = pharmacyRest.getForObject(URL_PHARMACY, List.class);
            output.addAll(response);

        } catch (Exception e){
            logger.error("Error buscando las farmacias", e);
            output = null;
        }

        return output;
    }


}
