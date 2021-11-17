package com.hiro11.fleeapp.controllers;

import com.hiro11.fleeapp.models.VehicleType;
import com.hiro11.fleeapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    //Get All VehicleTypes
    @GetMapping("vehicleTypes")
    public String findAll(Model model){
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
        return "vehicleType";
    }

    @RequestMapping("vehicleTypes/findById")
    @ResponseBody
    public Optional<VehicleType> findById(int id)
    {
        return vehicleTypeService.findById(id);
    }

    //Add VehicleType
    @PostMapping(value="vehicleTypes/addNew")
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value="vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value="vehicleTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicleTypes";
    }

}
