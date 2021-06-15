package com.Karthik.cloudroot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Karthik.cloudroot.model.AccountInfo;
import com.Karthik.cloudroot.repos.AccountRepo;


@RestController
@RequestMapping("/accountapi")
public class AccountController {
	
	
	@Autowired
	AccountRepo repo;
	
	
	@PostMapping(value = "/accountinfo")
	public AccountInfo account(@RequestBody AccountInfo accountNumber) {
		System.out.println("accountNumber" +accountNumber);
		return repo.save(accountNumber);
		
	}


}
