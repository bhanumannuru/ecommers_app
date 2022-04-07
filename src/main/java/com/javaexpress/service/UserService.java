package com.javaexpress.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.entities.Address;
import com.javaexpress.entities.User;
import com.javaexpress.repos.AddressRepository;
import com.javaexpress.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public void saveUser(User user) {
		userRepo.save(user);
		//prepareUserAndAddress(user);
		
	}

	private void prepareUserAndAddress(User user) {
		User userRequest = new User();
		userRequest.setEmail(user.getEmail());
		userRequest.setFirstName(user.getFirstName());
		userRequest.setLastName(user.getLastName());
		userRequest.setEnabled(true);
		
		List<Address> address = new ArrayList<>();
		
		for(Address addressReq : user.getAddresses()) {
			Address add = new Address();
			add.setStreet(addressReq.getStreet());
			add.setCity(addressReq.getCity());
			add.setCountry(addressReq.getCountry());
			add.setPostcode(addressReq.getPostcode());
			address.add(add);
		}
		userRequest.setAddresses(address);
		userRepo.save(userRequest);
	
	}
}
