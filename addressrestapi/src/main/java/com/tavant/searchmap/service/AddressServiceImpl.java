package com.tavant.searchmap.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.searchmap.repository.AddressRepository;


 
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    
    @Autowired
    
    private AddressRepository addressRepository;

 

    @Override
    public List<String> search(String keyword) {
       
        return addressRepository.search(keyword);
    }
    

 

}