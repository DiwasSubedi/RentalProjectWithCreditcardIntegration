package com.himalayanGeeks.carRental.service;

import com.himalayanGeeks.carRental.domain.Permissions;

public interface PermissionService {
	
	Permissions findbyuser(int uid);

}
