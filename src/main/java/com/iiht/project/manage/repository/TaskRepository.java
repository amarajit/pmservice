package com.iiht.project.manage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.project.manage.domain.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, String>{
	
	@Query(value = " FROM Task WHERE project=:project")
	List<Task> findByProjectId(@Param("project") String projectId);

}
