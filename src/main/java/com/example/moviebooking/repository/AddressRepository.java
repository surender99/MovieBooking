package com.example.moviebooking.repository;

import com.example.moviebooking.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> getAddressByCity(String city);
}
