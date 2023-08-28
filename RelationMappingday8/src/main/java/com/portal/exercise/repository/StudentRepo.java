package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.StudentModel;

public interface StudentRepo extends JpaRepository<StudentModel, Integer> {

}
