package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
