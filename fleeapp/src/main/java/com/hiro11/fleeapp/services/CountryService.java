package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.Country;
import com.hiro11.fleeapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Return list of countries
    public List<Country> getCountries() {

        return countryRepository.findAll();
    }

    //Save new country.js
    public void save(Country country){

        countryRepository.save(country);
    }

    //Get Country By Id
    public Optional<Country> findById(int id) {

        return countryRepository.findById(id);
    }

    //Delete Country
    public void delete(int id) {

        countryRepository.deleteById(id);
    }

}
