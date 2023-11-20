package com.Project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.demo.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

	User findAllById(long id);

	List<User> findAll();

	@Query(value = "select us from user_table us where us.username = ?1", nativeQuery = true)
	public User findByUserName(String username);
}
