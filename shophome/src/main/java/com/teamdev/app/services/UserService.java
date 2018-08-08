package com.teamdev.app.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teamdev.app.domain.Roles;
import com.teamdev.app.domain.Users;
import com.teamdev.app.repository.UsersRepository;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository userRepository;
	
	public void createUser(Users user) {
		BCryptPasswordEncoder code = new BCryptPasswordEncoder();
		user.setPassword(code.encode(user.getPassword()));
		Roles role = new Roles();
		role.setName("USER");
		Set<Roles> roles = new HashSet<Roles>();
		roles.add(role);
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	public void createAdmin(Users user) {
		BCryptPasswordEncoder code = new BCryptPasswordEncoder();
		user.setPassword(code.encode(user.getPassword()));
		Roles role = new Roles();
		role.setName("ADMIN");
		Set<Roles> roles = new HashSet<Roles>();
		roles.add(role);
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	public Users findOne(String login) {
		return userRepository.findByUsername(login).get();
	}
	
	public List<Users> findAll() {
		return userRepository.findAll();
	}
	
	public boolean isUserPresent(String login) {
		Users u = userRepository.findByUsername(login).get();
		if(u!=null)
			return true;
		
		return false;
	}

}
