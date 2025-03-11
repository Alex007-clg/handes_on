package com.alex.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.springapp.entity.AdminDetails;

public interface AdminDetailsRepo extends JpaRepository<AdminDetails,Long>{
    
}
