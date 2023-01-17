package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Address;
import com.example.moviebooking.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class AddressController {
        @Autowired
        private AddressService addressService;

        @PostMapping("/address/addAddress")
        public Address addAddress(@RequestBody Address address) {
            return addressService.saveAddress(address);
        }

        @GetMapping("/address/getAddress/{id}")
        public Address getAddress(@PathVariable int id) {
            return addressService.getAddressById(id);
        }

        @GetMapping("/getAddress/getCity/{city}")
        public List<Address> getAddress(@PathVariable String city) {
            return addressService.getAddressByCity(city);
        }

        @PutMapping("/address/updateAddress")
        public Address updateAddress(@RequestBody Address address) {
            return addressService.updateAddress(address);
        }

        @DeleteMapping("/address/deleteAddress")
        public String deleteAddress(int id) {
            return addressService.deleteAddress(id);
        }
}
