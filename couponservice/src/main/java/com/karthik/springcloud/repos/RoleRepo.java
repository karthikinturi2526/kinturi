package com.karthik.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.springcloud.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
