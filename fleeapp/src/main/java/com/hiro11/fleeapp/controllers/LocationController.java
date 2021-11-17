package com.hiro11.fleeapp.controllers;

import com.hiro11.fleeapp.models.Country;
import com.hiro11.fleeapp.models.Location;
import com.hiro11.fleeapp.models.State;
import com.hiro11.fleeapp.services.CountryService;
import com.hiro11.fleeapp.services.LocationService;
import com.hiro11.fleeapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    @GetMapping("locations")
    public String findAll(Model model) {

        List<State> stateList = stateService.getState();
        List<Country> countryList = countryService.getCountries();
        List<Location> locationList = locationService.getLocations();

        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);
        model.addAttribute("locations", locationList);

        return "location";
    }

    @GetMapping("locations/findById")
    @ResponseBody
    public Optional<Location> findById(int id) {

        return locationService.findById(id);
    }

    @PostMapping("locations/addNew")
    public String save(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id) {
        locationService.delete(id);
        return "redirect:/locations";
    }
}