package com.karthik.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
