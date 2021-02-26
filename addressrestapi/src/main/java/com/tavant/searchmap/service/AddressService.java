package com.tavant.searchmap.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface AddressService {
	public List<String> search(@Param("keyword")String keyword);

}
