package com.gamoland.rearingapp.controllers;

import com.gamoland.rearingapp.models.Owner;
import com.gamoland.rearingapp.services.interfaces.ColonyService;
import com.gamoland.rearingapp.services.interfaces.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    private final ColonyService colonyService;
    private final OwnerService ownerService;

    @Autowired
    public MainController(ColonyService colonyService, OwnerService ownerService) {
        this.colonyService = colonyService;
        this.ownerService = ownerService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    //TODO finish not matching password message
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute Owner owner, String confirm, Model model){
        if (owner.getPassword().equals(confirm) && ownerService.validemil(owner)){
            ownerService.save(owner);
            return "redirect:/";
        }
        model.addAttribute("passwordmatch", false);
        return "register";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model model){
        if (ownerService.findByUsername(username).isPresent()){
            ownerService.matchUserPassword(username, password);
            return "main";
        }
        model.addAttribute("text", "User does not exist! Please register!");
        return "error";
    }
}
