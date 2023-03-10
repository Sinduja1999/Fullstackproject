package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.BusManagement;

/*@Repository-is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects  
JPA Repository is mainly used for managing the data in a Spring Boot Application*/
/*JpaRepository<BusManagement,Integer>*/


@Repository
public interface BusManagementRepository extends JpaRepository<BusManagement,Integer >{

}


