package com.karthik.springcloud.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.karthik.springcloud.dtos.Coupon;
import com.karthik.springcloud.model.Product;
import com.karthik.springcloud.repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestControllers {
	
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponService.url}")
	private String couponServiceURL;
	
	@PostMapping("/products")
	public Product create(@RequestBody Product product) {
		
		Coupon coupon = restTemplate.getForObject(couponServiceURL+product.getCouponCode(), Coupon.class);
		
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
		
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> findById(@PathVariable("id") Long id){
	    return repo.findById(id);
	}
	public Product sendErrorResponse(Product product) {
		return product;
		
	}

}
