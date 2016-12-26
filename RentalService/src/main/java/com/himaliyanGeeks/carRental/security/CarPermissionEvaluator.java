package com.himaliyanGeeks.carRental.security;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.himalayanGeeks.carRental.domain.Permissions;
import com.himalayanGeeks.carRental.domain.User;
import com.himalayanGeeks.carRental.service.PermissionService;
import com.himalayanGeeks.carRental.service.UserService;
@Component
public class CarPermissionEvaluator implements PermissionEvaluator {
	
	@Autowired
	UserService userservice;
	@Autowired
	PermissionService perserv;

	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		User currentuser =(User) auth.getPrincipal();		
		System.out.println("Inside Interceptor of hasPermission" + currentuser.getUserName());
		Permissions permissionofUser  = perserv.findbyuser(currentuser.getId());
		if(permissionofUser.getPermission()==permission.toString()){
			return true;
		}
		else
			return false;		
	
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

}
