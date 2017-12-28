package com.iiht.project.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iiht.project.manage.domain.User;
import com.iiht.project.manage.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("")
	public List<User> users() {
		return (List<User>) userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User user(@PathVariable("id") String id) {
		return userRepository.findOne(id);
	}

	@PostMapping("")
	public ResponseEntity<?> add(@RequestBody User user) {
		User _user = userRepository.save(user);

		assert _user != null;
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/" + _user.getId()).buildAndExpand().toUri());

		return new ResponseEntity<>(_user, httpHeaders, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		userRepository.delete(id);
		
	}

}
