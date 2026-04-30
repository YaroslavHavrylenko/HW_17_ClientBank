package org.example.clientbank.dao;

import org.example.clientbank.model.Employer;
import org.example.clientbank.repositiry.EmployerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployerDao implements Dao<Employer> {
    private final EmployerRepository employerRepository;

    public EmployerDao(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Employer save(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public boolean delete(Employer employer) {
        employerRepository.delete(employer);
        return true;
    }

    @Override
    public void deleteAll(List<Employer> employers) {
        employerRepository.deleteAll(employers);
    }

    @Override
    public void saveAll(List<Employer> employers) {
        employerRepository.saveAll(employers);
    }

    @Override
    public List<Employer> findAll() {
        return employerRepository.findAll();
    }

    @Override
    public boolean deleteById(long id) {
        if (!employerRepository.existsById(id)) {
            return false;
        }
        employerRepository.deleteById(id);
        return true;
    }

    @Override
    public Employer getOne(long id) {
        return employerRepository.findById(id).orElse(null);
    }
}
