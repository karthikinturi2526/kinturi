package com.karthik.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.springcloud.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
