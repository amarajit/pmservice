package com.iiht.project.manage.domain;

import java.util.Map;

public class TaskRestRequest {

	private String id;
	private String parentId;
	private String project;
	private String task;
	private Map<String, Object> startDate;
	private Map<String, Object> endDate;
	private String priority;
	private String status;
	private String user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Map<String, Object> getStartDate() {
		return startDate;
	}

	public void setStartDate(Map<String, Object> startDate) {
		this.startDate = startDate;
	}

	public Map<String, Object> getEndDate() {
		return endDate;
	}

	public void setEndDate(Map<String, Object> endDate) {
		this.endDate = endDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
