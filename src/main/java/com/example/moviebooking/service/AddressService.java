package com.example.moviebooking.service;

import com.example.moviebooking.entity.Address;
import com.example.moviebooking.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> saveAddresses(List<Address> addresses) {
        return addressRepository.saveAll(addresses);
    }

    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElse(null);
    }
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }
    public List<Address> getAddressByCity(String city) {
        return addressRepository.getAddressByCity(city);
    }

    public String deleteAddress(int id) {
        addressRepository.deleteById(id);
        return "Address Deleted " + id;
    }

    public Address updateAddress(Address address) {
        Address addrTemp = addressRepository.findById(address.getId()).orElse(null);
        if(addrTemp == null)
            return null;
        addrTemp.setArea(address.getArea());
        addrTemp.setCity(address.getCity());
        addrTemp.setMallName(address.getMallName());
        return addressRepository.save(addrTemp);
    }
}

