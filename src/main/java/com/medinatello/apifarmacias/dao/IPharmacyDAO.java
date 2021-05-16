package com.medinatello.apifarmacias.dao;


import com.medinatello.apifarmacias.domain.entity.Pharmacy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPharmacyDAO extends CrudRepository<Pharmacy, Long> {

    @Query("select u from Pharmacy u where u.comuna_nombre=?1")
    List<Pharmacy> findByComuna(String username);

}
