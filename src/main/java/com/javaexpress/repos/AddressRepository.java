package com.javaexpress.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaexpress.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository <Address, Long> {
}