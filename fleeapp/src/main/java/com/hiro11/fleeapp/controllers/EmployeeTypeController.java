package com.hiro11.fleeapp.controllers;

import com.hiro11.fleeapp.models.EmployeeType;
import com.hiro11.fleeapp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeService employeeTypeService;

    //Get All EmployeeTypes
    @GetMapping("employeeTypes")
    public String findAll(Model model){
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
        return "employeeType";
    }

    @RequestMapping("employeeTypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(int id)
    {
        return employeeTypeService.findById(id);
    }

    //Add EmployeeType
    @PostMapping(value="employeeTypes/addNew")
    public String addNew(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value="employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value="employeeTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id) {
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }

}
