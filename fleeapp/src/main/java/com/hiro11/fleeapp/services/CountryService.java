package com.hiro11.fleeapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiro11.fleeapp.models.Country;
import com.hiro11.fleeapp.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	// Return list of countries
	public List<Country> getCountries(){
		return countryRepository.findAll();
	}

}
