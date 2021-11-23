package com.hiro11.fleeapp.controllers;

import com.hiro11.fleeapp.models.Employee;
import com.hiro11.fleeapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StateService stateService;

    @Autowired
    private JobTitleService jobTitleService;

    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private CountryService countryService;

    //Get All Employees
    @GetMapping("employees")
    public String findAll(Model model){
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getState());
        model.addAttribute("employees", employeeService.getEmployee());
        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());

        return "employee";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id)
    {
        return employeeService.findById(id);
    }

    //Add Employee
    @PostMapping(value="employees/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value="employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value="employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    //Assign Employee Username
    @RequestMapping(value = "employees/assignUsername")
    public  String assignUsername(int id){
        employeeService.assignUsername(id);
        return "redirect:/employees";
    }

    /*
    @RequestMapping(value="/employees/uploadPhoto", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File newFile = new File("D:\\SOLUTIONS\\fleetms\\uploads" + file.getOriginalFilename());
        newFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(newFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }


    @PostMapping("/employees/uploadPhoto2")
    public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal)
            throws IllegalStateException, IOException {
        String baseDirectory = "D:\\SOLUTIONS\\fleetms\\src\\main\\resources\\static\\img\\photos\\" ;
        file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
        return "redirect:/employees";
    }


    @RequestMapping(value="/employees/profile")
    public String profile(Model model, Principal principal) {
        String un = principal.getName();
        model.addAttribute("employee", employeeService.findByUsername(un));
        return "profile";
    }

     */
}
