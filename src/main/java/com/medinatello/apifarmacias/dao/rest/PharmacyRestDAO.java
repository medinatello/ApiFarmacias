package com.medinatello.apifarmacias.dao.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medinatello.apifarmacias.domain.entity.Pharmacy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class PharmacyRestDAO {

    private static final String URL_PHARMACY  = "https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion?id_region=7";
    private Logger logger = LoggerFactory.getLogger(PharmacyRestDAO.class);


    public List<Pharmacy> getPharmacy(){
        List<Pharmacy> output = new ArrayList<>();

        try{

            RestTemplate pharmacyRest = new RestTemplate();

            final TypeReference<List<Pharmacy>> typeRef = new TypeReference<List<Pharmacy>>(){};
            var response = pharmacyRest.getForObject(URL_PHARMACY, String.class );

            ObjectMapper mapper = new ObjectMapper();
            Pharmacy[] Pharmacies = mapper.readValue(response, Pharmacy[].class);

            output.addAll(Arrays.asList(Pharmacies));

        } catch (Exception e){
            logger.error("Error buscando las farmacias", e);
            output = null;
        }

        return output;
    }

}
