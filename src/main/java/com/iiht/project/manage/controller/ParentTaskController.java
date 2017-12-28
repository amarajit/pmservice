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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iiht.project.manage.domain.ParentTask;
import com.iiht.project.manage.repository.ParentTaskRepository;

@RestController
@RequestMapping("/parenttasks")
public class ParentTaskController {
	
	@Autowired
	ParentTaskRepository parentTaskRepository;

	@GetMapping("")
	public List<ParentTask> tasks() {
		return (List<ParentTask>) parentTaskRepository.findAll();
	}

	@GetMapping("/{id}")
	public ParentTask user(@PathVariable("id") String id) {
		return parentTaskRepository.findOne(id);
	}

	@PostMapping("")
	public ResponseEntity<?> add(@RequestBody ParentTask task) throws ParseException {
		ParentTask _task = parentTaskRepository.save(task);

		assert _task != null;
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/" + _task.getId()).buildAndExpand().toUri());

		return new ResponseEntity<>(_task, httpHeaders, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		parentTaskRepository.delete(id);
	}

}
