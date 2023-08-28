package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
