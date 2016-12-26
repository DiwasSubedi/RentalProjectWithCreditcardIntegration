package com.himalayanGeeks.carRental.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himalayanGeeks.carRental.domain.SalesFile;
import com.himalayanGeeks.carRental.domain.User;


@Service
@Transactional
public class UserServiceImpl implements com.himalayanGeeks.carRental.service.UserService{

	@Autowired
	com.himalayanGeeks.carRental.repository.UserRepository userRepository;
	

	@Override
	public User save(User user) {
		Date date = new Date(); 	 
    	SalesFile.setDate(date);
    	SimpleDateFormat dt1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		System.out.println(dt1.format(date));
    	SalesFile.creatFileAndWrite(user.toString() + "is created and saved on time" +dt1.format(date));
		userRepository.save(user);
		return user;
	}

	

	@Override
	public List<User> findByName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public User findById(int id) {

		return userRepository.findOne(id);
	}



	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}



	@Override
	public void delete(Integer id) {
		userRepository.delete(id);
		
	}



	@Override
	public void edit(User user) {
		userRepository.delete(user.id);
		userRepository.save(user);

	}



	@Override
	public User findByUsername(String username) {
		return userRepository.findByuserName(username);
	}



	

	

}
