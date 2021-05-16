package com.medinatello.apifarmacias.dao;

import com.medinatello.apifarmacias.dao.rest.PharmacyRestDAO;
import com.medinatello.apifarmacias.domain.entity.Pharmacy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PharmacyRepo {

    private Logger logger = LoggerFactory.getLogger(PharmacyRepo.class);

    @Autowired
    private IPharmacyDAO pharmacyDAO;

    @Autowired
    private PharmacyRestDAO pharmacyRestDAO;

    public Boolean addRestToPersistence(){

        return validatePersistence();

    }

    public List<Pharmacy> getAll(){
        if(!validatePersistence()){
            return null;
        }
        List<Pharmacy> output = null;
        try{

            output =  StreamSupport.stream(pharmacyDAO.findAll().spliterator(), false)
                    .collect(Collectors.toList());

        }catch (Exception e){
            output = null;
        }
        return output;
    }


    public List<Pharmacy> getAllByComunas(String comuna){
        if(!validatePersistence()){
            return null;
        }
        List<Pharmacy> output = null;
        try{

            output =  StreamSupport.stream(pharmacyDAO.findByComuna(comuna).spliterator(), false)
                    .collect(Collectors.toList());

        }catch (Exception e){
            output = null;
        }
        return output;
    }

    private Boolean addRange(List<Pharmacy> pharmacies){
        Boolean output = true;
        try{
            pharmacyDAO.saveAll(pharmacies);
        }catch(Exception e){
            logger.error("Error agregando persistencia", e);
            output = false;
        }
        return output;
    }

    private Boolean validatePersistence(){

        if(pharmacyDAO.count() == 0){
            var pharmacies = pharmacyRestDAO.getPharmacy();
            if(pharmacies == null){
                return false;
            }
            if(!addRange(pharmacies)){
                return false;
            }
            logger.info("Primera carga de datos realizada");
        }

        return true;

    }

}
