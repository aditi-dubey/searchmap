package com.tavant.searchmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.searchmap.models.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
