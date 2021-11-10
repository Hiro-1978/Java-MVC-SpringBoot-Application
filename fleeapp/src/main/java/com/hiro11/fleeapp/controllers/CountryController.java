package com.hiro11.fleeapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hiro11.fleeapp.models.Country;
import com.hiro11.fleeapp.services.CountryService;

@Controller
public class CountryController {
	
	@Autowired 
	private CountryService countryService;
	
	//Get All Country
	@GetMapping("/countries")
	public String getCountries(Model model){
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		return "country";
	}	
}