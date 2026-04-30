package org.example.clientbank.controller;

import org.example.clientbank.service.EmployerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/employers")
public class EmployerUiController {

    private final EmployerService employerService;

    public EmployerUiController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping
    public String getEmployers(Model model) {
        model.addAttribute("employers", employerService.getAllEmployers());
        return "employers";
    }
}