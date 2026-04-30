package org.example.clientbank.service;

import org.example.clientbank.model.Customer;
import org.example.clientbank.model.Employer;
import org.example.clientbank.repositiry.CustomerRepository;
import org.example.clientbank.repositiry.EmployerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final CustomerRepository customerRepository;

    public EmployerService(EmployerRepository employerRepository, CustomerRepository customerRepository) {
        this.employerRepository = employerRepository;
        this.customerRepository = customerRepository;
    }

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public Employer getEmployer(Long id) {
        return employerRepository.findById(id).orElse(null);
    }

    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    public Employer updateEmployer(Long id, Employer employer) {
        Employer existing = employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
        existing.setName(employer.getName());
        existing.setAddress(employer.getAddress());
        return employerRepository.save(existing);
    }

    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }

    @Transactional
    public boolean addCustomerToEmployer(Long customerId, Long employerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Employer employer = employerRepository.findById(employerId).orElse(null);
        if (customer == null || employer == null) {
            return false;
        }
        customer.addEmployer(employer);
        customerRepository.save(customer);
        return true;
    }

    @Transactional
    public boolean removeCustomerFromEmployer(Long customerId, Long employerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Employer employer = employerRepository.findById(employerId).orElse(null);
        if (customer == null || employer == null) {
            return false;
        }
        customer.removeEmployer(employer);
        customerRepository.save(customer);
        return true;
    }
}
