package com.alex.springapp.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.alex.springapp.entity.Admin;
import com.alex.springapp.service.AdminService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/")
public class AdminController {
    @Autowired
    AdminService obj;

    @GetMapping("admins/get")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return new ResponseEntity<>(obj.getAllAdmins(), HttpStatus.OK);
    }

    @GetMapping("admins/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        Optional<Admin> item = obj.getUser(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body("Id not found");
    }

    @PostMapping("admins/post")
    public ResponseEntity<Optional<Admin>> postAdmin(@RequestBody Admin mess) {
        return new ResponseEntity<>(obj.postAdmin(mess), HttpStatus.OK);
    }

    @PutMapping("admins/update/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody Admin mess, @PathVariable int id) {
        Optional<Admin> item = obj.updateDetails(mess,id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        Map<String, String> response = new LinkedHashMap<>();
        response.put("Success", "false");
        response.put("Message", "id not found");
        return ResponseEntity.status(404).body(response);
    }
    
    @DeleteMapping("admins/delete/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable int id) {
        Optional<Admin> item = obj.deleteAdmin(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        Map<String, String> response = new LinkedHashMap<>();
        response.put("Success", "false");
        response.put("Message", "id not found");
        return ResponseEntity.status(404).body(response);
    }

    

    @GetMapping("getPage/{size}/{PageNo}")
    public ResponseEntity<?> getByPage(@PathVariable int PageNo, @PathVariable int size) {
        List<Admin> item = obj.getAdminsByPage(PageNo, size);
        if (!item.isEmpty()) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        
        return ResponseEntity.status(404).body("No items present");
    }

    @GetMapping("admin/sortBy/{field}")
    public ResponseEntity<List<Admin>> getSored(@PathVariable String field)
    {
        return new ResponseEntity<>(obj.sort(field), HttpStatus.OK);

    }

}
