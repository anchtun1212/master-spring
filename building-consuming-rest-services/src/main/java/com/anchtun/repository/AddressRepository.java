package com.anchtun.repository;

import org.springframework.data.repository.CrudRepository;

import com.anchtun.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
