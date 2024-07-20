package com.userservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entities.User;
import com.userservice.exception.ResouceNotFoundException;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userid) {
		// TODO Auto-generated method stub
		return userRepository.findById(userid).orElseThrow(
				() -> new ResouceNotFoundException("User with given is not found in the server " + userid));
	}

	@Override
	public void deleteUser(String userid) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userid);
	}

	@Override
	public User updateUser(String userid, User newUser) {
		// TODO Auto-generated method stub
		User editUser = userRepository.findById(userid).get();

		editUser.setName(newUser.getName());
		editUser.setEmail(newUser.getEmail());
		editUser.setAbout(newUser.getAbout());

		return userRepository.save(editUser);
	}

}
