package com.iiht.project.manage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.project.manage.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
