package com.himalayanGeeks.carRental.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.himalayanGeeks.carRental.domain.Car;
import com.himalayanGeeks.carRental.domain.Permissions;


@Repository
public interface PermissionRepository extends CrudRepository<Permissions, Long> {

	
	
	
	@Query("select p from Permissions p where p.user.id = :id")
    Permissions findbyuser(@Param("id") int id);
	
	
}
