package com.alex.springapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.springapp.Repository.AdminDetailsRepo;
import com.alex.springapp.entity.AdminDetails;


@Service
public class AdminDetailsService {
    
    @Autowired
    private AdminDetailsRepo adminDetailsRepo;

    public AdminDetails saveUser(AdminDetails details) {
        return adminDetailsRepo.save(details);
    }

    public Optional<AdminDetails> getUserById(Long id) {
        return adminDetailsRepo.findById(id);
    }

    public void DeleteDetails(Long id) {
        adminDetailsRepo.deleteById(id);
    }

}
