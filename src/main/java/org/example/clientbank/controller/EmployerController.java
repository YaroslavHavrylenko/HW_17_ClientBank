package org.example.clientbank.controller;

import jakarta.validation.Valid;
import org.example.clientbank.controller.dto.RequestBodyCreateEmployer;
import org.example.clientbank.model.Employer;
import org.example.clientbank.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping
    public ResponseEntity<List<Employer>> getAllEmployers() {
        return ResponseEntity.ok(employerService.getAllEmployers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employer> getEmployer(@PathVariable Long id) {
        Employer employer = employerService.getEmployer(id);
        return employer == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(employer);
    }

    @PostMapping
    public ResponseEntity<Employer> createEmployer(@Valid @RequestBody RequestBodyCreateEmployer body) {
        Employer employer = new Employer(body.getName(), body.getAddress());
        return ResponseEntity.status(HttpStatus.CREATED).body(employerService.createEmployer(employer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable Long id, @Valid @RequestBody RequestBodyCreateEmployer body) {
        Employer employer = new Employer(body.getName(), body.getAddress());
        return ResponseEntity.ok(employerService.updateEmployer(id, employer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{employerId}/customers/{customerId}")
    public ResponseEntity<Void> addCustomerToEmployer(@PathVariable Long employerId, @PathVariable Long customerId) {
        return employerService.addCustomerToEmployer(customerId, employerId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{employerId}/customers/{customerId}")
    public ResponseEntity<Void> removeCustomerFromEmployer(@PathVariable Long employerId, @PathVariable Long customerId) {
        return employerService.removeCustomerFromEmployer(customerId, employerId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
