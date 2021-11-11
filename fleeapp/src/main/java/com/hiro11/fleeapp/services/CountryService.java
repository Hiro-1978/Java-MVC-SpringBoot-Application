package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.Country;
import com.hiro11.fleeapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Return list of countries
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    //Save new country
    public void save(Country country){
        countryRepository.save(country);
    }
}
