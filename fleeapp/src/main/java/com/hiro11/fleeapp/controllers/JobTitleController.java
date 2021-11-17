package com.hiro11.fleeapp.controllers;

import com.hiro11.fleeapp.models.JobTitle;
import com.hiro11.fleeapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class JobTitleController {
    @Autowired
    private JobTitleService jobTitleService;

    //Get All JobTitles
    @GetMapping("jobTitles")
    public String findAll(Model model){
        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        return "jobTitle";
    }

    @RequestMapping("jobTitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(int id)
    {
        return jobTitleService.findById(id);
    }

    //Add JobTitle
    @PostMapping(value="jobTitles/addNew")
    public String addNew(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value="jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value="jobTitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id) {
        jobTitleService.delete(id);
        return "redirect:/jobTitles";
    }
}
