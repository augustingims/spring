package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		BCryptPasswordEncoder code = new BCryptPasswordEncoder();
		user.setPassword(code.encode(user.getPassword()));
		Role role = new Role("USER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	public void createAdmin(User user) {
		BCryptPasswordEncoder code = new BCryptPasswordEncoder();
		user.setPassword(code.encode(user.getPassword()));
		Role role = new Role("ADMIN");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	public User findOne(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public boolean isUserPresent(String email) {
		User u = userRepository.findByEmail(email);
		if(u!=null)
			return true;
		
		return false;
	}

	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return  userRepository.findByNameLike("%"+name+"%");
	}
}
