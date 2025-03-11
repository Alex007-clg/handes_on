package com.alex.springapp.controller;

import com.alex.springapp.entity.AdminDetails;
import com.alex.springapp.service.AdminDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/adminDetails")
public class AdminDetailsController {
    @Autowired 
    AdminDetailsService obj;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AdminDetails>> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(obj.getUserById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AdminDetails> postUser(@RequestBody AdminDetails details) {
        return new ResponseEntity<>(obj.saveUser(details), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        obj.DeleteDetails(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
