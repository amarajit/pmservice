package com.iiht.project.manage.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id", updatable = false, nullable = false)
	private String id;
	private String project;
	private Date startDate;
	private Date endDate;
	private String priority;
	private String managerId;
	private int taskCount;
	private int completedTaskCount;

	public Project() {
	}

	public Project(String id, String project, Date startDate, Date endDate, String priority, String managerId,
			int taskCount, int completedTaskCount) {
		this.id = id;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.managerId = managerId;
		this.taskCount = taskCount;
		this.completedTaskCount = completedTaskCount;
	}

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public int getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}

	public int getCompletedTaskCount() {
		return completedTaskCount;
	}

	public void setCompletedTaskCount(int completedTaskCount) {
		this.completedTaskCount = completedTaskCount;
	}

}
