package com.hiro11.fleeapp.controllers;

import com.hiro11.fleeapp.models.State;
import com.hiro11.fleeapp.services.CountryService;
import com.hiro11.fleeapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StateController {


    @Autowired
    private StateService stateService;
    @Autowired private CountryService countryService;

    //Get All States
    @GetMapping("states")
    public String findAll(Model model){
        model.addAttribute("states", stateService.getState());
        model.addAttribute("countries", countryService.getCountries());
        return "state";
    }

    @RequestMapping("states/findById")
    @ResponseBody
    public Optional<State> findById(int id){
        return stateService.findById(id);
    }

    //Add State
    @PostMapping(value="states/addNew")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value="states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value="states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id) {
        stateService.delete(id);
        return "redirect:/states";
    }
}

