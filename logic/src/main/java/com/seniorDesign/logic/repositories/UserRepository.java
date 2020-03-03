package com.seniorDesign.logic.repositories;

import com.seniorDesign.logic.Pojo.USERS;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<USERS, Integer> {
}

