package com.alex.springapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.alex.springapp.entity.Admin;

import jakarta.transaction.Transactional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
    
    @Modifying
    @Transactional
    @Query(value="insert into Admin (ID,Name,email) values(?,?,?)",nativeQuery = true)
    void postPerson(int id, String name, String email);
    
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Admin WHERE id = ?", nativeQuery = true)
    int deleteAdmin(int id);

    
    @Query("Select a from Admin a")
    List<Admin> getUsers();

    
    @Query(value = "select * from Admin where id=? LIMIT 1",nativeQuery = true)
    Optional<Admin> getSingleUser(int id);


    @Modifying
    @Transactional
    @Query(value = "update Admin SET name = ?2 where id = ?1",nativeQuery = true)
    void UpdateAdminName(int id, String value);
    
    
    @Modifying
    @Transactional
    @Query(value = "update Admin SET email = ?2 where id = ?1",nativeQuery = true)
    void UpdateAdminEmail(int id, String value);
    
}
