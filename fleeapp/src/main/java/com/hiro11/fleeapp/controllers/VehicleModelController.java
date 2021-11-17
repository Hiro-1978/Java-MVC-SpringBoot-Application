package com.hiro11.fleeapp.controllers;

import com.hiro11.fleeapp.models.VehicleModel;
import com.hiro11.fleeapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleModelController {
    @Autowired
    private VehicleModelService vehicleModelService;

    //Get All VehicleModels
    @GetMapping("vehicleModels")
    public String findAll(Model model){
        model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
        return "vehicleModel";
    }

    @RequestMapping("vehicleModels/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(int id)
    {
        return vehicleModelService.findById(id);
    }

    //Add VehicleModel
    @PostMapping(value="vehicleModels/addNew")
    public String addNew(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value="vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value="vehicleModels/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id) {
        vehicleModelService.delete(id);
        return "redirect:/vehicleModels";
    }
}
