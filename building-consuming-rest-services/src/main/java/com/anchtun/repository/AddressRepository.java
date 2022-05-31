package com.anchtun.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
