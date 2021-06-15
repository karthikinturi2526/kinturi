package com.karthik.springcloud;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
