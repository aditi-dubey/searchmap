

package com.tavant.searchmap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tavant.searchmap.models.Address;



@Repository("AddressRepository")

public interface AddressRepository extends JpaRepository<Address, Integer> {
	@Query(value="select name from product where name like %:keyword% ",nativeQuery=true) 
	public List<String> search(@Param("keyword") String keyword);
	
	

}



