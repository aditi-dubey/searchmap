package com.tavant.searchmap.controllers;



 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

 

import javax.validation.Valid;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.searchmap.models.Address;
import com.tavant.searchmap.repository.AddressRepository;





 


@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AddressController {
    
    @Autowired
    AddressRepository addressRepository;
    
    @PostMapping("/saveaddress")
    public Address addAddress(@RequestBody @Valid Address address){

        return addressRepository.save(address);
    }
    @GetMapping("/getaddress")
    public List<Address> getAddress(){
        List<Address> address=new ArrayList<Address>();
        address=addressRepository.findAll();
        return address;
    }

 

}