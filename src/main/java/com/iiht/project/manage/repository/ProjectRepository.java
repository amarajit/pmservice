package com.iiht.project.manage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.project.manage.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String>{

}
