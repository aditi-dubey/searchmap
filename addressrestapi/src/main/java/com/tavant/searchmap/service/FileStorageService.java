package com.tavant.searchmap.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.tavant.searchmap.models.Address;
import com.tavant.searchmap.models.FileDB;
import com.tavant.searchmap.models.ResponseFile;
import com.tavant.searchmap.repository.AddressRepository;
import com.tavant.searchmap.repository.FileDBRepository;

@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;
  
  @Autowired
  private AddressRepository addressRepository;

  public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
    String s = new String(FileDB.getData(), StandardCharsets.UTF_8);
	System.out.println(s);

	String[] a = s.split("\\n");
	try {
	for (String i : a) {
		System.out.println("Inside");
		String[] Array2 = i.split(",");
		System.out.println("outside address creation");
		Address address = new Address();
		System.out.println("inside address creation");
		System.out.println(address);
		address.setHouseNumber(Integer.parseInt(Array2[0]));
		System.out.println("inside address creation");
		address.setHouseName(Array2[1]);
		System.out.println("inside address creation");
		address.setPoi(Array2[2]);
		System.out.println("inside address creation");
		address.setStreet(Array2[3]);
		System.out.println("inside address creation");
		address.setSubSubLocality(Array2[4]);
		System.out.println("inside address creation");
		address.setSubLocality(Array2[5]);
		System.out.println("inside address creation");
		address.setLocality(Array2[6]);
		System.out.println("inside address creation");
		address.setVillage(Array2[7]);
		System.out.println("inside address creation");
		address.setSubDistrict(Array2[8]);
		System.out.println("inside address creation");
		address.setDistrict(Array2[9]);
		System.out.println("inside address creation");
		address.setCity(Array2[10]);
		System.out.println("inside address creation");
		address.setState(Array2[11]);
		System.out.println("inside address creation");
		address.setPincode(Array2[12]);
		System.out.println("inside address creation");
		address.setFormattedAddress(Array2[13]);
		System.out.println("inside address creation");
		address.setELoc(Array2[14]);
		System.out.println("inside address creation");
		address.setGeocodeLevel(Array2[15]);
		System.out.println("inside address creation");
		System.out.println(address);
		address.setConfidenceScore(Float.parseFloat(Array2[16]));
		System.out.println(address);
		
		System.out.println(address);
		boolean bool = Validate(address);
		System.out.println(bool);
		if(bool==true) {
			addressRepository.save(address);
		}
		else {
			
		}
	}
	}
	catch(Exception e){
		e.printStackTrace();
		
	}

	return null;
//    return fileDBRepository.save(FileDB);
  }
  public boolean Validate(Address address) {
		
		System.out.println(address.getELoc());
		String variable = address.getELoc().replaceAll("\\s", "");
		String var = String.format("http://apis.mapmyindia.com/advancedmaps/v1/7bmu4k3flar6dd1llwukelt3d4qd1nc7/place_detail?place_id=%s",variable);
		System.out.println(var);
		RestTemplate rest = new RestTemplate();
		ResponseFile response =rest.getForObject(var, ResponseFile.class);
		System.out.println("outside if");
		if(response.getResponseCode()==200 && response.getResults().size()>0) {
			System.out.println("inside If");
			
			return true;
		}
		else {
			System.out.println("inside else");
			System.out.println(response.getResponseCode());
			return false;
		}
		
		
	}
  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
