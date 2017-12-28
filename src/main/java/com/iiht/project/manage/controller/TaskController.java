package com.iiht.project.manage.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iiht.project.manage.domain.Task;
import com.iiht.project.manage.repository.TaskRepository;

@RestController
public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	@GetMapping("/tasks")
	public List<Task> tasks() {
		return (List<Task>) taskRepository.findAll();
	}

	@GetMapping("/tasks/{id}")
	public Task user(@PathVariable("id") String id) {
		return taskRepository.findOne(id);
	}

	@PostMapping("/tasks")
	public ResponseEntity<?> add(@RequestBody Task task) throws ParseException {
		Task _task = taskRepository.save(task);

		assert _task != null;
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/" + _task.getId()).buildAndExpand().toUri());

		return new ResponseEntity<>(_task, httpHeaders, HttpStatus.CREATED);
	}

	@DeleteMapping("/tasks/{id}")
	public void delete(@PathVariable("id") String id) {
		taskRepository.delete(id);
	}

}
