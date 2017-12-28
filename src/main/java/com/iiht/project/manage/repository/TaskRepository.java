package com.iiht.project.manage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.project.manage.domain.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, String>{

}
