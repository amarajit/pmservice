package com.iiht.project.manage.domain;

import java.util.Map;

public class ProjectRestRequest {

	private String id;
	private String project;
	private Map<String, Object> startDate;
	private Map<String, Object> endDate;
	private String priority;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
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

}
