package com.iiht.project.manage.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iiht.project.manage.domain.Project;
import com.iiht.project.manage.domain.Task;
import com.iiht.project.manage.domain.TaskStatus;
import com.iiht.project.manage.repository.ProjectRepository;
import com.iiht.project.manage.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	ProjectRepository projectRepository;

	@GetMapping("")
	public List<Task> tasks() {
		return (List<Task>) taskRepository.findAll();
	}

	@GetMapping("/project/{projectId}")
	public List<Task> projectSpecificTasks(@PathVariable("projectId") String projectId) {
		return (List<Task>) taskRepository.findByProjectId(projectId);
	}

	@GetMapping("/{id}")
	public Task user(@PathVariable("id") String id) {
		return taskRepository.findOne(id);
	}

	@PostMapping("")
	public ResponseEntity<?> add(@RequestBody Task task) throws ParseException {
		Task _task = null;
		boolean isTaskAlreadyCompleted = false;
		if(!StringUtils.isEmpty(task.getId()) && task.getStatus().equalsIgnoreCase("Completed")) {
			_task = taskRepository.findOne(task.getId());
			if(!StringUtils.isEmpty(_task.getStatus()) && _task.getStatus().equalsIgnoreCase("Completed")){
				isTaskAlreadyCompleted = true;
			}				
		}
		
		_task = taskRepository.save(task);
		HttpHeaders httpHeaders = new HttpHeaders();
		// Update the task count in project table only if new task is added.
		if (null != _task && !StringUtils.isEmpty(_task.getProject())) {
			if (null != task) {
				Project _project = projectRepository.findOne(_task.getProject());
				if (StringUtils.isEmpty(task.getId())) {
					if (null != _project) {
						_project.setTaskCount(_project.getTaskCount() + 1);
						projectRepository.save(_project);
					}
				} else {
					if(!StringUtils.isEmpty(task.getStatus())&& task.getStatus().equalsIgnoreCase("Completed") && !isTaskAlreadyCompleted) {
						if (null != _project) {
							_project.setCompletedTaskCount(_project.getCompletedTaskCount() + 1);
							projectRepository.save(_project);
						}
					}
				}
			}
			httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + _task.getId())
					.buildAndExpand().toUri());
		}

		return new ResponseEntity<>(_task, httpHeaders, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		taskRepository.delete(id);
	}

	/*
	 * @GetMapping("/count/{projectId}") public int
	 * getTaskCount(@PathVariable("projectId") String projectId) { List<Task> tasks
	 * = taskRepository.findByProjectId(projectId); int taskCount = 0; if (null !=
	 * tasks) { taskCount = tasks.size(); } return taskCount; }
	 * 
	 * @GetMapping("/status/{projectId}") public TaskStatus
	 * getTasksStatus(@PathVariable("projectId") String projectId) { List<Task>
	 * tasks = taskRepository.findByProjectId(projectId); int taskCount = 0; if
	 * (null != tasks) { taskCount = tasks.size(); }
	 * 
	 * int completedTaskCount = 0; for (Task task : tasks) { if (null != task &&
	 * !StringUtils.isEmpty(task.getStatus()) &&
	 * task.getStatus().equalsIgnoreCase(task.getStatus())) { completedTaskCount++;
	 * } }
	 * 
	 * TaskStatus status = new TaskStatus(); status.setTaskCount(taskCount);
	 * status.setCompletedTaskCount(completedTaskCount); return status; }
	 */

}
