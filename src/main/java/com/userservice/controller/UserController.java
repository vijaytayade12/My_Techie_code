package com.userservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entities.User;
import com.userservice.service.UserService;

/**
 * This is a controller class
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUserId(@PathVariable String userId) {

		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUser = userService.getAllUsers();
		return ResponseEntity.ok(allUser);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<User> removeUser(@PathVariable String userId) {
		User existingUser = userService.getUser(userId);
		if (existingUser != null) {
			this.userService.deleteUser(existingUser.getUserId());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping("/edit/{userId}")
	public User updateCustomer(@PathVariable String userId, @RequestBody User newUser) {
		return userService.updateUser(userId, newUser);
	}

}
