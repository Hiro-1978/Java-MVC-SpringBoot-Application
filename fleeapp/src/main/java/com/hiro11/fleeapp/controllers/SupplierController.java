package com.hiro11.fleeapp.controllers;

import com.hiro11.fleeapp.models.Supplier;
import com.hiro11.fleeapp.services.CountryService;
import com.hiro11.fleeapp.services.StateService;
import com.hiro11.fleeapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private SupplierService supplierService;

    //Get All Suppliers
    @GetMapping("suppliers")
    public String findAll(Model model){
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getState());
        model.addAttribute("suppliers", supplierService.getSuppliers());
        return "supplier";
    }

    @RequestMapping("suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(Integer id)
    {
        return supplierService.findById(id);
    }

    //Add Supplier
    @PostMapping(value="suppliers/addNew")
    public String addNew(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value="suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value="suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
