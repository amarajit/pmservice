package com.iiht.project.manage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParentTask {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parent_id", updatable = false, nullable = false)
	private String id;
	private String task;

	public ParentTask() {
	}

	public ParentTask(String id, String task) {
		super();
		this.id = id;
		this.task = task;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setParentTask(String task) {
		this.task = task;
	}

}
