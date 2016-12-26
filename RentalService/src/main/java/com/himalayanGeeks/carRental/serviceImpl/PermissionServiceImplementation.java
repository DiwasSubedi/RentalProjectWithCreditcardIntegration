package com.himalayanGeeks.carRental.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himalayanGeeks.carRental.domain.Permissions;
import com.himalayanGeeks.carRental.repository.PermissionRepository;
import com.himalayanGeeks.carRental.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImplementation implements PermissionService {

	@Autowired
	PermissionRepository perrepo;
	
	@Override
	public Permissions findbyuser(int uid) {
		return (Permissions)perrepo.findbyuser(uid); 
		
	}

}
