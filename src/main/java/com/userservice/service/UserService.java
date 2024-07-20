package com.userservice.service;

import java.util.List;

import com.userservice.entities.User;

public interface UserService {

	// create users
	public User saveUser(User user);

	// Get all users
	public List<User> getAllUsers();

	// Get only one user
	public User getUser(String userid);

	// update user
	public User updateUser(String userid, User user);

	// delete user
	public void deleteUser(String userid);

}
