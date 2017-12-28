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

import com.iiht.project.manage.domain.Project;
import com.iiht.project.manage.repository.ProjectRepository;

@RestController
public class ProjectController {
	
	
	@Autowired
	ProjectRepository projectRepository;

	@GetMapping("/projects")
	public List<Project> projects() {
		return (List<Project>) projectRepository.findAll();
	}

	@GetMapping("/projects/{id}")
	public Project project(@PathVariable("id") String id) {
		return projectRepository.findOne(id);
	}

	@PostMapping("/projects")
	public ResponseEntity<?> add(@RequestBody Project project) throws ParseException {
		Project _project = projectRepository.save(project);

		assert _project != null;
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/" + _project.getId()).buildAndExpand().toUri());

		return new ResponseEntity<>(_project, httpHeaders, HttpStatus.CREATED);
	}

	@DeleteMapping("/projects/{id}")
	public void delete(@PathVariable("id") String id) {
		projectRepository.delete(id);
	}
	

}
