package com.karthik.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.karthik.springcloud.model.Coupon;
import com.karthik.springcloud.repos.CouponRepo;

@Controller
public class CouponController {
	
	@Autowired
	private CouponRepo repo;
	
	
	
	@GetMapping("/showCreateCoupon")
	public String showCreateCoupon() {
		return "createCoupon";
	}
	
	
	@PostMapping("/saveCoupon")
	public String save(Coupon coupon) {
		repo.save(coupon);
		return "createReponse";
		
	}
	
	@GetMapping("/showGetCoupon")
	public String showGetCoupon() {
		return "getCoupon";
		
	}
	
	@PostMapping("/getCoupon")
	public ModelAndView getCoupon(String code) {
		ModelAndView mav = new ModelAndView("couponDetails");
		mav.addObject(repo.findByCode(code));
		return mav;
		
	}

}
