package com.hiro11.fleeapp.controllers;

import com.hiro11.fleeapp.models.Contact;
import com.hiro11.fleeapp.services.ContactService;
import com.hiro11.fleeapp.services.CountryService;
import com.hiro11.fleeapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private ContactService contactService;

    //Get All Contacts
    @GetMapping("/contacts")
    public String findAll(Model model){
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getState());
        model.addAttribute("contacts", contactService.getContacts());
        return "contact";
    }

    @RequestMapping("contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(Integer id)
    {
        return contactService.findById(id);
    }

    //Add Contact
    @PostMapping(value="contacts/addNew")
    public String addNew(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value="contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value="contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
