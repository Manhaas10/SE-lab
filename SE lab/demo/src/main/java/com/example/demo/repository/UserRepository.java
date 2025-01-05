package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

    @Query(value = "SELECT * FROM Users as u WHERE Trim(LOWER(u.Name)) = LOWER(:Name)", nativeQuery = true)
    List<User> findByName(@Param("Name") String Name);
    

}