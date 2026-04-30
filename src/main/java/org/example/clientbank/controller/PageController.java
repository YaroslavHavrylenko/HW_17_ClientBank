package org.example.clientbank.controller;

import org.example.clientbank.model.Currency;
import org.example.clientbank.model.Customer;
import org.example.clientbank.service.CustomerService;
import org.example.clientbank.service.EmployerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    private final CustomerService customerService;
    private final EmployerService employerService;

    public PageController(CustomerService customerService, EmployerService employerService) {
        this.customerService = customerService;
        this.employerService = employerService;
    }

    @GetMapping({"/", "/ui/customers"})
    public String customers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("employers", employerService.getAllEmployers());
        return "customers";
    }

    @PostMapping("/ui/customers")
    public String createCustomer(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam int age) {
        customerService.createCustomer(new Customer(name, email, age));
        return "redirect:/ui/customers";
    }

    @GetMapping("/ui/customers/{id}")
    public String customer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerInfo(id));
        model.addAttribute("currencies", Currency.values());
        return "customer";
    }

    @PostMapping("/ui/customers/{id}/accounts")
    public String createAccount(@PathVariable Long id, @RequestParam Currency currency) {
        customerService.createAccountForCustomer(id, currency);
        return "redirect:/ui/customers/" + id;
    }

    @PostMapping("/ui/customers/{customerId}/accounts/{accountId}/delete")
    public String deleteAccount(@PathVariable Long customerId, @PathVariable Long accountId) {
        customerService.deleteAccountForCustomer(customerId, accountId);
        return "redirect:/ui/customers/" + customerId;
    }
}
